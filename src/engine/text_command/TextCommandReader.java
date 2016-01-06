package engine.text_command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextCommandReader {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<String, ITextCommand> cmdMap = new LinkedHashMap<>();

    private Runner runner;

    private final class Runner implements Runnable {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;

        @Override
        public void run() {
            while (running) {
                try {
                    executeCommand(br.readLine());
                } catch (IOException e) {
                    running = false;
                }
            }
        }

    }

    public TextCommandReader() {
        cmdMap.put("help", new CmdPrintHelp(cmdMap));
    }

    public void addCommand(String name, ITextCommand cmd) {
        assert (!cmdMap.containsKey(name));
        cmdMap.put(name, cmd);
    }

    public void start() {
        assert (runner == null);
        runner = new Runner();
        new Thread(runner).start();
    }

    public void stop() {
        assert (runner != null);
        try {
            runner.br.close();
        } catch (IOException e) {
            LOGGER.error("Closing BufferedReader failed");
        }
        runner = null;
    }

    private void executeCommand(final String line) {
        LOGGER.trace("execute command: " + line);
        String[] words = line.split(" ");
        if (words.length > 0) {
            ITextCommand cmd = cmdMap.get(words[0]);
            if (cmd != null) {
                try {
                    cmd.execute(words);
                } catch (IndexOutOfBoundsException e) {
                    LOGGER.error("not enough arguments, " + words[0] + ": " + cmd.getDescription());
                } catch (NumberFormatException e) {
                    LOGGER.error("illegal argument format, " + words[0] + ": " + cmd.getDescription());
                }
            } else {
                LOGGER.error("unknown command, \"help\" to print available commands");
            }
        }
    }

}

package engine.text_command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        cmdMap.put("help", new TextCmdPrintHelp(cmdMap));
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
        String[] words = line.split(" ");
        if(words.length > 0) {
            ITextCommand cmd = cmdMap.get(words[0]);
            if (cmd != null) {
                cmd.execute(words);
            } else {
                LOGGER.error("unknown command, \"help\" to print available commands");
            }
        }
    }

}

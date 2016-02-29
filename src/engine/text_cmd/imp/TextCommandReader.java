package engine.text_cmd.imp;

import engine.text_cmd.ITextCommand;
import engine.text_cmd.ITextCommandReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

final class TextCommandReader implements ITextCommandReader {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<String, ITextCommand> cmdMap = new LinkedHashMap<>();
    private final CmdPrintHelp cmdHelp = new CmdPrintHelp(cmdMap);

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public TextCommandReader() {
        cmdMap.put("help", cmdHelp);

        new Thread(() -> {
            while (true) {
                try {
                    executeCommand(br.readLine());
                } catch (IOException e) {
                    break;
                }
            }
        }).start();
    }

    public synchronized void addCommand(String name, ITextCommand cmd) {
        assert (!cmdMap.containsKey(name));
        cmdMap.put(name, cmd);
    }

    public synchronized void clearCommands() {
        cmdMap.clear();
        cmdMap.put("help", cmdHelp);
    }

    @Override
    public synchronized void shutdown() {
        try {
            br.close();
        } catch (IOException e) {
            LOGGER.error("Closing BufferedReader failed");
        }
    }

    private synchronized void executeCommand(final String line) {
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


    public static void main(String[] args) {
        ITextCommandReader x = new TextCommandReader();
        x.shutdown();
    }

}

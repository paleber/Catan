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
import java.util.Scanner;

final class TextCommandReader implements ITextCommandReader {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<String, ITextCommand> cmdMap = new LinkedHashMap<>();
    private final CmdPrintHelp cmdHelp = new CmdPrintHelp(cmdMap);

    private final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    private final Scanner scanner = new Scanner(System.in);

    private boolean running = false;

    private final Runnable runner = () -> {
        while (true) {
            try {
                executeCommand(bufferedReader.readLine());
            } catch (IOException e) {
                break;
            }
        }
    };

    public TextCommandReader() {
        cmdMap.put("help", cmdHelp);
    }

    @Override
    public void start() {
        assert (!running);
        running = true;
        new Thread(runner).start();
    }

    public /*synchronized*/ void addCommand(String name, ITextCommand cmd) {
        assert (!cmdMap.containsKey(name));
        cmdMap.put(name, cmd);
    }

    public /*synchronized*/ void clearCommands() {
        cmdMap.clear();
        cmdMap.put("help", cmdHelp);
    }

    @Override
    public /*synchronized*/ void shutdown() {
        LOGGER.trace("Shutting down");
        try {
            scanner.close();
            LOGGER.trace("CCCCCCCCC");
            inputStreamReader.close();
            LOGGER.trace("AAAAAAAAA");
            bufferedReader.close();
            LOGGER.trace("BBBBBBBBBB");
        } catch (IOException e) {
            LOGGER.error("Closing BufferedReader failed");
        }
        LOGGER.trace("Shutted down");
    }

    private /*synchronized*/ void executeCommand(final String line) {
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

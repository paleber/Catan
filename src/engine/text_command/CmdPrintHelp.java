package engine.text_command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectArrayMessage;

import java.util.Map;

/** TextCommand for printing help on console. */
final class CmdPrintHelp implements ITextCommand {

    private static final Logger LOGGER = LogManager.getLogger();
    private final Map<String, ITextCommand> cmdMap;

    public CmdPrintHelp(final Map<String, ITextCommand> cmdMap) {
        this.cmdMap = cmdMap;
    }

    @Override
    public void execute(final String... args) {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }
        for (String cmd : cmdMap.keySet()) {
            LOGGER.info(cmd + cmdMap.get(cmd).getDescription());
        }
    }

    @Override
    public String getDescription() {
        return ": print the help";
    }



}

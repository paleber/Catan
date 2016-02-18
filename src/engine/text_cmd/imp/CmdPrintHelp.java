package engine.text_cmd.imp;

import engine.text_cmd.ITextCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        LOGGER.info("The following commands are available:");
        for (String cmd : cmdMap.keySet()) {
            LOGGER.info(cmd + ": " + cmdMap.get(cmd).getDescription());
        }
    }

    @Override
    public String getDescription() {
        return "print the help";
    }

}

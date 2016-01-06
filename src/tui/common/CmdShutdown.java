package tui.common;

import engine.control.IControlManager;
import engine.text_command.ITextCommand;

public final class CmdShutdown implements ITextCommand {

    private final IControlManager cm;

    public CmdShutdown(final IControlManager cm) {
        this.cm = cm;
    }

    @Override
    public void execute(final String... args) {
        cm.shutdown();
    }

    @Override
    public String getDescription() {
        return "shutdown the application";
    }

}

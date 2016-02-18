package tui.common;

import engine.control.IMainControl;
import engine.text_cmd.ITextCommand;

public final class CmdShutdown implements ITextCommand {

    private final IMainControl cm;

    public CmdShutdown(final IMainControl cm) {
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

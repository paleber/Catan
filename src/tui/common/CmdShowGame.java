package tui.common;

import control.GameMainControl;
import engine.control.IControlManager;
import engine.text_command.ITextCommand;

public class CmdShowGame implements ITextCommand {

    private final IControlManager cm;

    public CmdShowGame(final IControlManager cm) {
        this.cm = cm;
    }

    @Override
    public void execute(final String... args) {
        cm.switchControl(GameMainControl.class);
    }

    @Override
    public String getDescription() {
        return "show the game";
    }

}

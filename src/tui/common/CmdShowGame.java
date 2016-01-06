package tui.common;

import control.GameControl;
import engine.control.IControlManager;
import engine.text_command.ITextCommand;

public class CmdShowGame implements ITextCommand {

    private final IControlManager cm;

    public CmdShowGame(final IControlManager cm) {
        this.cm = cm;
    }

    @Override
    public void execute(final String... args) {
        cm.switchControl(GameControl.class);
    }

    @Override
    public String getDescription() {
        return "show the game";
    }

}

package tui.common;

import control.game.GameControl;
import engine.control.IMainControl;
import engine.text_cmd.ITextCommand;

public class CmdShowGame implements ITextCommand {

    private final IMainControl cm;

    public CmdShowGame(final IMainControl cm) {
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

package tui.common;

import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.text_cmd.ITextCommand;

public class CmdShowMenu implements ITextCommand {

    private final IMainControl cm;

    public CmdShowMenu(final IMainControl cm) {
        this.cm = cm;
    }

    @Override
    public void execute(final String... args) {
        cm.switchControl(MenuControl.class);
    }

    @Override
    public String getDescription() {
        return "show the menu";
    }

}

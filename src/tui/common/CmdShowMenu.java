package tui.common;

import control.MenuControl;
import engine.control.IControlManager;
import engine.text_command.ITextCommand;

public class CmdShowMenu implements ITextCommand {

    private final IControlManager cm;

    public CmdShowMenu(final IControlManager cm) {
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

package tui.menu;

import control.menu.MenuControl;
import engine.text_cmd.ITextCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CmdSetNumberPlayers implements ITextCommand {

    private static final Logger LOGGER = LogManager.getLogger();

    private final MenuControl menu;

    public CmdSetNumberPlayers(MenuControl menu) {
        this.menu = menu;
    }

    @Override
    public void execute(String... args) {
        int n = Integer.parseInt(args[1]);
        menu.setNumberPlayer(n);
    }

    @Override
    public String getDescription() {
        return "set the number of players, requires one arguments";
    }

}

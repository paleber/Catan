package tui.menu;

import control.exception.CatanException;
import control.exception.PlayerNotExistsException;
import control.menu.IMenuObserver;
import control.menu.MenuControl;
import engine.text_cmd.ITextCommand;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CmdRemovePlayer extends TextCommand {

    private static final Logger LOGGER = LogManager.getLogger();

    private final IMenuObserver menu;

    public CmdRemovePlayer(IMenuObserver menu) {
        this.menu = menu;
    }
    
    @Override
    protected void execute() throws IndexOutOfBoundsException, NumberFormatException {
        String name = parseString();
        try {
            menu.removePlayer(name);
        } catch (CatanException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "set the number of players, argument is the number";
    }

}

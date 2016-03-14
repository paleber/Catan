package tui.menu;

import control.menu.MenuControl;

import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CmdAddPlayer extends TextCommand {

    private static final Logger LOGGER = LogManager.getLogger();

    private final MenuControl menu;

    public CmdAddPlayer(MenuControl menu) {
        this.menu = menu;
    }

    @Override
    protected void execute() throws IndexOutOfBoundsException, NumberFormatException {
        String name = parseString();

        try {
            menu.addPlayer(name);
        } catch (PlayerData.IllegalNumberOfPlayersException | PlayerData.IllegalNameException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "add a player, argument is the name";
    }

}

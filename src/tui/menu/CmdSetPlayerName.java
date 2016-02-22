package tui.menu;

import control.menu.MenuControl;
import engine.text_cmd.ITextCommand;
import model.common.PlayerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class CmdSetPlayerName extends TextCommand {

    private static final Logger LOGGER = LogManager.getLogger();

    private final MenuControl menu;

    public CmdSetPlayerName(MenuControl menu) {
        this.menu = menu;
    }

    @Override
    protected void execute() throws IndexOutOfBoundsException, NumberFormatException {
        String name = parseString();
        int index = parseInteger();

        try {
            menu.setPlayerName(name, index);
        } catch (PlayerData.IllegalNumberOfPlayersException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "set the number of players, arguments are name and index";
    }

}

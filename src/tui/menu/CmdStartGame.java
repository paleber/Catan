package tui.menu;

import control.exception.CatanException;
import control.menu.MenuControl;
import engine.text_cmd.ITextCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CmdStartGame implements ITextCommand {

    private static final Logger LOGGER = LogManager.getLogger();
    private final MenuControl menu;

    public CmdStartGame(final MenuControl menu) {
        this.menu = menu;
    }

    @Override
    public void execute(final String... args) {
        try {
            menu.startGame();
        } catch (CatanException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "show the game";
    }

}

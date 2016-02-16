package tui.menu;

import com.google.inject.Inject;
import control.menu.IMenuSubject;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import engine.text_command.TextCommandReader;
import tui.Tui;
import tui.common.CmdShowGame;
import tui.common.CmdShutdown;

public final class TuiMenuControl implements IMenuSubject {

    private static final Logger LOGGER = LogManager.getLogger();

    private TextCommandReader reader = new TextCommandReader();


    @Override
    public void initialize(IMainControl main, IView view) {
        assert (view instanceof Tui);
        LOGGER.trace("Initializing");

        Tui tui = (Tui) view;
        MenuControl menu = (MenuControl) main.getObserver(MenuControl.class);
        menu.addSubject(this);

        reader.addCommand("number", new CmdSetNumberPlayers(menu));// add set Number command
        //reader.addCommand("name");// add set Name command
        reader.addCommand("game", new CmdShowGame(main));
        reader.addCommand("exit", new CmdShutdown(main));
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        reader.start();
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        reader.stop();
    }

    @Override
    public void updatePlayerNames(String names) {
        LOGGER.info("Player names updated");
    }

}

package tui.menu;

import control.menu.IMenuSubject;
import control.menu.MenuControl;
import engine.control.IMainControl;
import engine.control.IControlObserver;
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
    public void initialize(IMainControl cm, IControlObserver main, IView view) {
        assert (view instanceof Tui);
        assert (main instanceof MenuControl);

        Tui tui = (Tui) view;
        MenuControl menu = (MenuControl) main;

        LOGGER.trace("Initializing");
        reader.addCommand("number", new CmdSetNumberPlayers(menu));// add set Number command
        //reader.addCommand("name");// add set Name command
        reader.addCommand("game", new CmdShowGame(cm));
        reader.addCommand("exit", new CmdShutdown(cm));
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

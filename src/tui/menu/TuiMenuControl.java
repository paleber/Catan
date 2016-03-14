package tui.menu;

import control.menu.IMenuSubject;
import control.menu.MenuControl;
import engine.control.IMainControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.Tui;
import tui.common.CmdShutdown;

public final class TuiMenuControl implements IMenuSubject<Tui> {

    private static final Logger LOGGER = LogManager.getLogger();

    private IMainControl main;
    private MenuControl observer;
    private Tui tui;

    @Override
    public void initialize(IMainControl main, Tui tui) {
        LOGGER.trace("Initializing");

        this.main = main;
        this.tui = tui;

        observer = main.getObserver(MenuControl.class);
        observer.addSubject(this);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");

        tui.addCommand("add", new CmdAddPlayer(observer));
        tui.addCommand("remove", new CmdRemovePlayer(observer));
        tui.addCommand("game", new CmdStartGame(observer));
        tui.addCommand("exit", new CmdShutdown(main));
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        tui.clearCommands();
    }

    @Override
    public void onPlayerAdded(String playerName) {
        LOGGER.info("Player added: " + playerName);
    }

    @Override
    public void onPlayerRemoved(String playerName) {
        LOGGER.info("Player removed: " + playerName);
    }
}

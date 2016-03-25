package tui.game;

import control.game.IGameObserver;
import control.game.IGameSubject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.Tui;

public final class TuiGameControl implements IGameSubject<Tui> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize(IGameObserver observer, Tui view) {
        LOGGER.trace("Initializing");
    }

    @Override
    public void onStart() {
        LOGGER.trace("Starting");
    }

    @Override
    public void onStop() {
        LOGGER.trace("Stopping");
    }

}

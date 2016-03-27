package tui.game;

import control.game.IGameControl;
import control.game.IGameSubject;
import model.game.event.IGameEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.Tui;

public final class TuiGameControl implements IGameSubject<Tui> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize(IGameControl observer, Tui view) {
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

    @Override
    public void onGameEvent(IGameEvent event) {
        // TODO
    }
}

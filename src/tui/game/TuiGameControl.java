package tui.game;

import engine.control.IControlSubject;
import engine.control.IMainControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.Tui;

public final class TuiGameControl implements IControlSubject<Tui> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void initialize(IMainControl main, Tui tui) {
        LOGGER.trace("Initializing");
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
    }

}

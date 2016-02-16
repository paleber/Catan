package tui.game;

import engine.control.IControlSubject;
import engine.control.IMainControl;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TuiGameControl implements IControlSubject {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void initialize(IMainControl main, IView view) {
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

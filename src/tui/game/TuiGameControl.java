package tui.game;

import engine.control.IControlManager;
import engine.control.IView;
import engine.control.IControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TuiGameControl implements IControl {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void initialize(IControlManager cm, IView view) {
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
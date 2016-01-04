package gui;

import engine.control.IControl;
import engine.control.IControlManager;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GuiGameControl implements IControl {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void initialize(IControlManager cm, IView view) {
        LOGGER.info("Initializing");
    }

    @Override
    public void start() {
        LOGGER.info("Starting");
    }

    @Override
    public void stop() {
        LOGGER.info("Stopping");
    }
}

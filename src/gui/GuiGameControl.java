package gui;

import engine.control.IMainControl;
import engine.control.IControlSubject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GuiGameControl implements IControlSubject<Gui> {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void initialize(IMainControl cm, Gui gui) {
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

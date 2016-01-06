package control;

import engine.control.IControlManager;
import engine.control.IControlSubject;
import engine.control.IMainControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GameControl implements IMainControl{

    private static final Logger LOGGER = LogManager.getLogger();

    private IControlManager controlManager;

    @Override
    public void initialize(IControlManager controlManager) {
        LOGGER.trace("Initializing");
        this.controlManager = controlManager;
    }

    @Override
    public void addControl(IControlSubject view) {

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

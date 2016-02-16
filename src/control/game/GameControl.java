package control.game;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IControlSubject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GameControl implements IControlObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    private IMainControl controlManager;

    @Override
    public void initialize(IMainControl controlManager) {
        LOGGER.trace("Initializing");
        controlManager.registerObserver(this);
        this.controlManager = controlManager;
    }

    @Override
    public void addSubject(IControlSubject view) {

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

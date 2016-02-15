package gui;

import control.menu.IMenuSubject;
import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GuiMenuControl implements IMenuSubject {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void initialize(IMainControl cm, IControlObserver observer, IView view) {
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

    @Override
    public void updatePlayerNames(String names) {

    }
}

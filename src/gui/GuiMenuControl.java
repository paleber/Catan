package gui;

import control.IMenuControl;
import engine.control.IControlManager;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class GuiMenuControl implements IMenuControl {

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

    @Override
    public void test() {
        System.out.println("testing Gui menu Controller");
    }
}

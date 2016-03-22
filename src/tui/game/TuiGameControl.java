package tui.game;

import engine.control.IControlObserver;
import engine.control.IControlSubject;
import engine.control.IMainControl;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tui.Tui;

public final class TuiGameControl implements IControlSubject<Tui> {

    private static final Logger LOGGER = LogManager.getLogger();



    @Override
    public void onInitialize(IView view, IControlObserver observer) {
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

}

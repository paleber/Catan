package control.game;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public final class GameControl implements IGameObserver {

    private static final Logger LOGGER = LogManager.getLogger();

    private IMainControl mainControl;

    private final List<IGameSubject> subjects = new LinkedList<>();


    @Override
    public void onInitialize(IMainControl mainControl) {
        LOGGER.trace("Initializing");
        this.mainControl = mainControl;
        mainControl.registerObserver(this);
    }

    @Override
    public void onSubjectAdded(IGameSubject subject) {
        subjects.add(subject);
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

package control;

import engine.control.IControlManager;
import engine.control.IControl;
import engine.control.IMainControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;


public final class MenuMainControl implements IMainControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private final List<IMenuControl> views = new LinkedList<>();

    private IControlManager controlManager;

    @Override
    public void initialize(IControlManager controlManager) {
        LOGGER.trace("Initializing");
        this.controlManager = controlManager;
    }

    @Override
    public void addControl(IControl view) {
        assert (view instanceof IMenuControl);
        views.add((IMenuControl) view);
    }

    @Override
    public void start() {
        LOGGER.trace("Starting");
        views.forEach(IMenuControl::start);
    }

    @Override
    public void stop() {
        LOGGER.trace("Stopping");
        views.forEach(IMenuControl::stop);
    }

}

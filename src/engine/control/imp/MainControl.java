package engine.control.imp;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

final class MainControl implements IMainControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<Class<? extends IControlObserver>, IControlObserver> observers = new HashMap<>();

    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IControlObserver activeObserver = null;

    public MainControl() {
        System.out.println("Main");
    }

    @Override
    public void registerView(IView view) {
        assert (!views.contains(view));
        views.add(view);
        //view.initialize(this);
    }

    @Override
    public void registerObserver(IControlObserver ctrl) {
        assert (!observers.containsKey(ctrl.getClass()));
        observers.put(ctrl.getClass(), ctrl);
        //ctrl.initialize(this);
    }

    @Override
    public <T extends IControlObserver> T getObserver(Class<T> type) {
        assert (observers.containsKey(type));
        return type.cast(observers.get(type));
    }

    @Override
    public void switchControl(Class<? extends IControlObserver> ctrl) {
        assert (observers.containsKey(ctrl));
        stopActiveControl();
        activeObserver = observers.get(ctrl);
        activeObserver.start();
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
        stopActiveControl();
        views.forEach(IView::shutdown);
    }

    private void stopActiveControl() {
        if (activeObserver != null) {
            activeObserver.stop();
        }
    }

    @Override
    public void addSharedData(Object data) {
        assert (!sharedData.containsKey(data.getClass()));
        sharedData.put(data.getClass(), data);
    }

    @Override
    public <T> T getSharedData(Class<T> type) {
        assert (sharedData.containsKey(type));
        return type.cast(sharedData.get(type));
    }

}

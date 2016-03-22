package engine.control.imp;

import engine.control.IControlSubject;
import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

final class MainControl implements IMainControl {

    private static final Logger LOGGER = LogManager.getLogger();

    private final Map<Class<? extends IControlObserver>, IControlObserver> observers = new HashMap<>();
    private final Map<Class<? extends IControlObserver>, List<IControlSubject>> subjects = new HashMap<>();
    // TODO inner class for observers and subjects map ?

    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IControlObserver activeObserver = null;

    @Override
    public void registerView(IView view) {
        assert (!views.contains(view));
        views.add(view);
        view.onInitialize(this);
        //view.onInitialize(this);
    }

    @Override
    public void registerObserver(IControlObserver ctrl) {
        assert (!observers.containsKey(ctrl.getClass()));
        observers.put(ctrl.getClass(), ctrl);
        subjects.put(ctrl.getClass(), new LinkedList<>());
        ctrl.onInitialize(this);
    }

    @Override

    public <C extends IControlObserver, V extends IView> void registerSubject(IControlSubject<C, V> subject) {
        Object o = new Object();
        C c = (C) o;

        C c; //Class<C> observerClass = new Class<C>();
        assert (!views.contains(c.getClass()));
    }

    @Override
    public <V extends IView, C extends IControlObserver> void registerSubject(Class<V> view, Class<C> observer) {
        assert (!views.contains(view));
        assert (observers.containsKey(observer));
    }

    /*
    @Override
    public <T extends IControlObserver> T getObserver(Class<T> type) {
        assert (observers.containsKey(type));
        return type.cast(observers.get(type));
    } */

    @Override
    public void switchControl(Class<? extends IControlObserver> ctrl) {
        assert (observers.containsKey(ctrl));
        stopActiveControl();
        activeObserver = observers.get(ctrl);
        activeObserver.onStart();
    }

    @Override
    public void shutdown() {
        LOGGER.trace("Shutting down");
        stopActiveControl();
        views.forEach(IView::onShutdown);
    }

    private void stopActiveControl() {
        if (activeObserver != null) {
            activeObserver.onStop();
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

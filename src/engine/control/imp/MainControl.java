package engine.control.imp;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IView;

import java.util.*;

public final class MainControl implements IMainControl {

    private final Map<Class<? extends IControlObserver>, IControlObserver> observers = new HashMap<>();


    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IControlObserver activeObserver = null;

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
    public IControlObserver getObserver(Class<? extends IControlObserver> type) {
        assert (observers.containsKey(type));
        return observers.get(type);
    }

    /*
    @Override
    public void registerSubject(IControlSubject ctrl, Class<? extends IControlObserver> type) {
        assert (observers.containsKey(type));
        observers.get(type).addSubject(ctrl);
        //ctrl.initialize(this, observer, view);
    } */

    @Override
    public void switchControl(Class<? extends IControlObserver> ctrl) {
        assert (observers.containsKey(ctrl));
        stopActiveControl();
        activeObserver = observers.get(ctrl);
        activeObserver.start();
    }

    @Override
    public void shutdown() {
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
    public Object getSharedData(Class<?> type) {
        assert (sharedData.containsKey(type));
        return sharedData.get(type);
    }

}

package engine.control.imp;

import engine.control.IMainControl;
import engine.control.IControlObserver;
import engine.control.IControlSubject;
import engine.control.IView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public final class MainControl implements IMainControl {

    private final Map<Class<? extends IControlObserver>, IControlObserver> observers = new HashMap<>();

    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IControlObserver activeObserver = null;

    @Override
    public void addView(IView view) {
        views.add(view);
        view.initialize(this);
    }

    @Override
    public void addObserver(IControlObserver ctrl) {
        assert (!observers.containsKey(ctrl.getClass()));
        observers.put(ctrl.getClass(), ctrl);
        ctrl.initialize(this);
    }

    @Override
    public void addSubject(IControlSubject ctrl, Class<? extends IControlObserver> type, IView view) {
        assert (observers.containsKey(ctrl));
        IControlObserver observer = observers.get(type);
        observer.addSubject(ctrl);
        ctrl.initialize(this, observer, view);
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

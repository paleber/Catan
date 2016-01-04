package engine.control.imp;

import engine.control.IControl;
import engine.control.IControlManager;
import engine.control.IMainControl;
import engine.control.IView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public final class ControlManager implements IControlManager {

    private final Map<Class<? extends IMainControl>, IMainControl> mainControls = new HashMap<>();

    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IMainControl activeControl = null;

    @Override
    public void registerView(IView view) {
        views.add(view);
        view.initialize(this);
    }

    @Override
    public void registerMainControl(IMainControl ctrl) {
        assert (!mainControls.containsKey(ctrl.getClass()));
        mainControls.put(ctrl.getClass(), ctrl);
        ctrl.initialize(this);
    }

    @Override
    public void registerControl(IControl ctrl, Class<? extends IMainControl> type, IView view) {
        assert (mainControls.containsKey(ctrl));
        mainControls.get(type).addControl(ctrl);
        ctrl.initialize(this, view);
    }

    @Override
    public void switchControl(Class<? extends IMainControl> ctrl) {
        assert (mainControls.containsKey(ctrl));
        stopActiveControl();
        activeControl = mainControls.get(ctrl);
        activeControl.start();
    }

    @Override
    public void shutdown() {
        stopActiveControl();
        views.forEach(IView::shutdown);
    }

    private void stopActiveControl() {
        if (activeControl != null) {
            activeControl.stop();
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
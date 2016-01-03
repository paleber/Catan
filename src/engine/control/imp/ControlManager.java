package engine.control.imp;

import engine.control.IControl;
import engine.control.IControlManager;
import engine.control.IMainControl;
import engine.control.IView;

import java.util.*;

public class ControlManager implements IControlManager {

    private final Map<Class<? extends IMainControl>, IMainControl> mainControls = new HashMap<>();
    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IMainControl activeControl = null;

    @Override
    public void registerView(IView view) {
        views.add(view);
        view.onInitialize();
    }

    @Override
    public void registerMainControl(IMainControl ctrl) {
        assert (!mainControls.containsKey(ctrl.getClass()));
        mainControls.put(ctrl.getClass(), ctrl);
    }

    @Override
    public void registerViewControl(IControl view, Class<? extends IMainControl> ctrl) {
        assert (mainControls.containsKey(ctrl));
        mainControls.get(ctrl).addView(view);
    }

    @Override
    public void switchControl(Class<? extends IMainControl> ctrl) {
        assert (mainControls.containsKey(ctrl));
        stopActiveControl();
        activeControl = mainControls.get(ctrl);
        activeControl.onStart();
    }

    @Override
    public void shutdown() {
        stopActiveControl();
        views.forEach(IView::onShutdown);
    }

    private void stopActiveControl() {
        if (activeControl != null) {
            activeControl.onStop();
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

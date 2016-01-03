package engine.control;

import java.util.*;

public class ControlManager {

    private final Map<Class<? extends IMainControl>, IMainControl> mainControls = new HashMap<>();
    private final List<IView> views = new LinkedList<>();
    private final Map<Class<?>, Object> sharedData = new HashMap<>();

    private IMainControl curControl = null;

    public void registerView(IView view) {
        views.add(view);
        view.onInitialize();
    }

    public void registerMainControl(IMainControl ctrl) {
        assert (!mainControls.containsKey(ctrl.getClass()));
        mainControls.put(ctrl.getClass(), ctrl);
    }

    public void registerViewControl(IControl view, Class<? extends IMainControl> ctrl) {
        assert (mainControls.containsKey(ctrl));
        mainControls.get(ctrl).addView(view);
    }

    public void switchControl(Class<? extends IMainControl> ctrl) {
        assert (mainControls.containsKey(ctrl));
        stopCurrentControl();
        curControl = mainControls.get(ctrl);
        curControl.onStart();
    }

    private void stopCurrentControl() {
        if (curControl != null) {
            curControl.onStop();
        }
    }

    public void shutdown() {
        stopCurrentControl();
        views.forEach(IView::onShutdown);
    }

    public void addSharedData(Object data) {
        assert (!sharedData.containsKey(data.getClass()));
        sharedData.put(data.getClass(), data);
    }

    public Object getSharedData(Class<?> type) {
        assert (sharedData.containsKey(type));
        return sharedData.get(type);
    }

}

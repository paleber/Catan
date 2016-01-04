package engine.control;

import tui.Tui;

public interface IControlManager {

    void registerView(IView view);

    void registerMainControl(IMainControl ctrl);

    void registerControl(IControl ctrl, Class<? extends IMainControl> type, IView view);

    void switchControl(Class<? extends IMainControl> ctrl);

    void shutdown();

    void addSharedData(Object data);

    Object getSharedData(Class<?> type);
}

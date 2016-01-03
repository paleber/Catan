package engine.control;

public interface IControlManager {

    void registerView(IView view);

    void registerMainControl(IMainControl ctrl);

    void registerViewControl(IControl view, Class<? extends IMainControl> ctrl);

    void switchControl(Class<? extends IMainControl> ctrl);

    void shutdown();

    void addSharedData(Object data);

    Object getSharedData(Class<?> type);
}

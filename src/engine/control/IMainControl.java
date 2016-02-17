package engine.control;

public interface IMainControl {

    void registerView(IView view);

    void registerObserver(IControlObserver observer);

    IControlObserver getObserver(Class<? extends IControlObserver> type);

    void switchControl(Class<? extends IControlObserver> type);

    void shutdown();

    void addSharedData(Object data);

    Object getSharedData(Class<?> type);

}

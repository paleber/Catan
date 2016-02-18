package engine.control;

public interface IMainControl {

    void registerView(IView view);

    void registerObserver(IControlObserver observer);

    <T extends IControlObserver> T getObserver(Class<T> type);

    void switchControl(Class<? extends IControlObserver> type);

    void shutdown();

    void addSharedData(Object data);

    <T> T getSharedData(Class<T> type);

}

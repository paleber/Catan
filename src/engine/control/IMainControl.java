package engine.control;

public interface IMainControl {

    void addView(IView view);

    void addObserver(IControlObserver ctrl);

    void addSubject(IControlSubject ctrl, Class<? extends IControlObserver> type, IView view);

    void switchControl(Class<? extends IControlObserver> ctrl);

    void shutdown();

    void addSharedData(Object data);

    Object getSharedData(Class<?> type);
}

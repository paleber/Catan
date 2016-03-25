package engine.control;

public interface IMainControl {

    void registerView(IView view);

    void registerObserver(IControlObserver observer);

    <S extends IControlSubject<O, V>, O extends IControlObserver, V extends IView> void registerSubject(S subject, Class<? extends O> observer, V view);

    void switchControl(Class<? extends IControlObserver> type);

    void shutdown();

    void addSharedData(Object data);

    <D> D getSharedData(Class<D> type);
}

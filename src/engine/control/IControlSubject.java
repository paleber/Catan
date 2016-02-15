package engine.control;

public interface IControlSubject {

    void initialize(IMainControl cm, IControlObserver ctrl, IView view);

    void start();

    void stop();

}

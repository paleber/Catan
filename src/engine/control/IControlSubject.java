package engine.control;

public interface IControlSubject {

    void initialize(IControlManager cm, IMainControl ctrl, IView view);

    void start();

    void stop();

}

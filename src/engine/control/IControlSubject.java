package engine.control;

public interface IControlSubject {

    void initialize(IMainControl cm, IView view);

    void start();

    void stop();

}

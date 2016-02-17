package engine.control;

public interface IControlSubject<T extends IView>{

    void initialize(IMainControl cm, T view);

    void start();

    void stop();

}

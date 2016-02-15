package engine.control;

public interface IControlObserver {

    void addSubject(IControlSubject control);

    void initialize(IMainControl cm);

    void start();

    void stop();

}

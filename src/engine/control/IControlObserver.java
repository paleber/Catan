package engine.control;

public interface IControlObserver {

    void addSubject(IControlSubject subject);

    void initialize(IMainControl main);

    void start();

    void stop();

}

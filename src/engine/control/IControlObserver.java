package engine.control;

public interface IControlObserver<T extends IControlSubject> {

    void addSubject(T subject);

    void initialize(IMainControl main);

    void start();

    void stop();

}

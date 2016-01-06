package engine.control;

public interface IMainControl {

    void addControl(IControlSubject control);

    void initialize(IControlManager cm);

    void start();

    void stop();

}

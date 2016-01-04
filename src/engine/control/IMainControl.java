package engine.control;

public interface IMainControl {

    void addControl(IControl control);

    void initialize(IControlManager cm);

    void start();

    void stop();

}

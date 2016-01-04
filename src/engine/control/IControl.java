package engine.control;

public interface IControl {

    void initialize(IControlManager cm, IView view);

    void start();

    void stop();

}
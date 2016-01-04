package engine.control;

public interface IView {

    void initialize(IControlManager cm); // TODO kann man auch alles im Konstruktor machen?

    void shutdown();

}
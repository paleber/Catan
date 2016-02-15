package engine.control;

public interface IView {

    void initialize(IMainControl cm); // TODO kann man auch alles im Konstruktor machen?

    void shutdown();

}
package engine.control;

public interface IView {

    void onInitialize(); // TODO kann man auch alles im Konstruktor machen?

    void onShutdown();

}
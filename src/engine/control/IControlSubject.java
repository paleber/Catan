package engine.control;

public interface IControlSubject<C extends IControlObserver, V extends IView> {

    void onInitialize(C observer, V view);

    void onStart();

    void onStop();

}

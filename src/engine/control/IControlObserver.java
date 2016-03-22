package engine.control;

public interface IControlObserver<T extends IControlSubject> {

    void onInitialize(IMainControl main);

    void onSubjectAdded(T subject);

    void onStart();

    void onStop();

}

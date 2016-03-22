package engine.control;

import control.game.GameControl;
import tui.Tui;
import tui.game.TuiGameControl;

public interface IMainControl {

    void registerView(IView view);

    void registerObserver(IControlObserver observer);


    /**
     * Add a Subject, view and observer must be already registered.
     *
     * @param view
     */
    <C extends IControlObserver, V extends IView> void registerSubject(IControlSubject<C, V> subject);

    // <T extends IControlObserver> T getObserver(Class<T> type); // remove

    void switchControl(Class<? extends IControlObserver> type);

    void shutdown();

    void addSharedData(Object data);

    <T> T getSharedData(Class<T> type);
}

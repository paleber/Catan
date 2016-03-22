package control.menu;


import engine.control.IControlSubject;
import engine.control.IView;

public interface IMenuSubject<V extends IView> extends IControlSubject<IMenuObserver, V> {

    void onPlayerAdded(String playerName);

    void onPlayerRemoved(String playerName);

}

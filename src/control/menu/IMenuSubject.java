package control.menu;


import engine.control.IControlSubject;
import engine.control.IView;

public interface IMenuSubject<T extends IView> extends IControlSubject<T> {

    void onPlayerAdded(String playerName);

    void onPlayerRemoved(String playerName);

}

package control.menu;


import engine.control.IControlSubject;
import engine.control.IView;

public interface IMenuSubject<T extends IView> extends IControlSubject<T> {

    void updateNumberOfPlayers(int number);

    void updatePlayerName(int index, String name);

}

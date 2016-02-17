package control.menu;


import engine.control.IControlSubject;
import engine.control.IView;

public interface IMenuSubject<T extends IView> extends IControlSubject<T> {

    void updatePlayerNames(String names);

}

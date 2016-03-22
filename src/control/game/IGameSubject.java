package control.game;


import engine.control.IControlSubject;
import engine.control.IView;

public interface IGameSubject<V extends IView> extends IControlSubject<IGameObserver, V> {

    // TODO

}

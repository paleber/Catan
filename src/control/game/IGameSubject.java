package control.game;


import engine.control.IControlSubject;
import engine.control.IView;
import model.game.event.IGameEvent;

public interface IGameSubject<V extends IView> extends IControlSubject<IGameControl, V> {

    void onGameEvent(IGameEvent event);

}

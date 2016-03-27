package control.game;

import engine.control.IControlObserver;
import model.game.event.IGameEvent;

public interface IGameControl extends IControlObserver<IGameSubject> {

    void sendGameEvent(IGameEvent event);

}

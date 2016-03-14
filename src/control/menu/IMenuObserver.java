package control.menu;

import control.exception.IllegalNameException;
import control.exception.IllegalNumberOfPlayersException;
import control.exception.NameInUseException;
import control.exception.PlayerNotExistsException;
import engine.control.IControlObserver;

public interface IMenuObserver extends IControlObserver<IMenuSubject> {

    void addPlayer(String name) throws NameInUseException, IllegalNameException, IllegalNumberOfPlayersException;

    void removePlayer(String name) throws PlayerNotExistsException;

    void startGame() throws IllegalNumberOfPlayersException;

}

package control.menu;

import engine.control.IControlObserver;

public interface IMenuObserver extends IControlObserver<IMenuSubject> {

    //void setNumberOfPlayers(int number);

   // void setPlayerName(String name, int index);

    void addPlayer(String name);

    void removePlayer(String name);

}

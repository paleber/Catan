package model.game;

public interface IGame {

     void rollDice();

     void buildStreet(int pathId);

     void buildCity(int intersectionId) ;

     void buildSettlement(int intersectionId) ;

     void finishTurn();

}

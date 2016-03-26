package model.game;

public interface IGame {

     void rollDice();

     void buildStreet(int pathId);

     void buildCity(int intersectionId) ;

     void buildVillage(int intersectionId) ;

     void finishTurn();

}

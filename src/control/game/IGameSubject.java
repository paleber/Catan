package control.game;


import engine.control.IControlSubject;
import engine.control.IView;
import model.game.IIntersection;
import model.game.IPath;
import model.game.IPlayer;
import model.game.ITerrain;

public interface IGameSubject<V extends IView> extends IControlSubject<IGameControl, V> {

    void onSetupGame(IIntersection[] intersections, IPath[] paths, ITerrain[] terrains, IPlayer[] players);

}

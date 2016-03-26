package control.game;

import engine.control.IControlObserver;
import model.game.IIntersection;
import model.game.IPath;
import model.game.IPlayer;
import model.game.ITerrain;

public interface IGameControl extends IControlObserver<IGameSubject> {

    void setupGame(IIntersection[] intersections, IPath[] paths, ITerrain[] terrains, IPlayer[] players);

}

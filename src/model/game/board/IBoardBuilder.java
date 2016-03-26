package model.game.board;


import model.game.object.Terrain;
import model.game.object.Intersection;
import model.game.object.Path;

public interface IBoardBuilder {

    Intersection[] getIntersections();

    Path[] getPaths();

    Terrain[] getTerrains();

}

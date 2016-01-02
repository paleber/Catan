package game.board;


import game.object.Field;
import game.object.Intersection;
import game.object.Path;

public interface IBoardBuilder {

    Intersection[] getIntersections();

    Path[] getPaths();

    Field[] getFields();

}

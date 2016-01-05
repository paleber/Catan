package model.game.board;


import model.game.object.Field;
import model.game.object.Intersection;
import model.game.object.Path;

public interface IBoardBuilder {

    Intersection[] getIntersections();

    Path[] getPaths();

    Field[] getFields();

}

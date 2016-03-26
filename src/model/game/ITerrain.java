package model.game;

/**
 * Created by Patrick on 26.03.2016.
 */
public interface ITerrain {

    int getId();

    int getNumber();

    Material getMaterial();

    IIntersection[] getIntersections();

}

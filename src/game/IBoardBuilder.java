package game;


public interface IBoardBuilder {

    void build();

    Intersection[] getIntersections();

    Path[] getPaths();

    Terrain[] getTerrains();

}

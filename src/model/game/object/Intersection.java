package model.game.object;

import geo.IPoint;

import java.util.ArrayList;
import java.util.List;

public class Intersection {



    enum status {
        FREE, BLOCKED, VILLAGE, CITY
    }

    private IPoint point;

    private final List<Intersection> nextIntersections = new ArrayList<>();
    private final List<Path> nextPaths = new ArrayList<>();

    private Player owner = null;


    public Intersection(IPoint point) {
        this.point = point;
    }

    public void addNeighbor(Path path) {
        nextPaths.add(path);
    }

    public void addNeighbor(Intersection intersection) {
        nextIntersections.add(intersection);
    }


}

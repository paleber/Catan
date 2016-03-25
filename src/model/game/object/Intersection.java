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
    private final List<Field> nextFields = new ArrayList<>();

    private Player owner = null;

    private static int idCounter = 0;
    private final int id = idCounter++;

    public Intersection(IPoint point) {
        this.point = point;

    }

    public void addNeighbor(Path next) {
        if (!nextPaths.contains(next)) {
            for(Path p: nextPaths) {
                next.addNeighbor(p);
                p.addNeighbor(next);
            }
            nextPaths.add(next);
        }
    }

    public void addNeighbor(Intersection next) {
        if (!nextIntersections.contains(next)) {
            nextIntersections.add(next);
        }
    }

    public void addNeighbor(Field next) {
        if (!nextFields.contains(next)) {
            nextFields.add(next);
        }
    }


}

package model.game.object;

import geo.IPoint;
import model.game.IIntersection;
import model.game.event.SetupIntersectionEvent;

import java.util.ArrayList;
import java.util.List;

public class Intersection implements IIntersection {


    public int getId() {
        return id;
    }

    @Override
    public IPoint getPoint() {
        return point; // TODO copy Point or make it immutable
    }

    public SetupIntersectionEvent createSetupEvent() {
        return new SetupIntersectionEvent(id, point.getX(), point.getY());
    }

    public Intersection[] getNeighborIntersections() {
        return nextIntersections.toArray(new Intersection[0]);
    }

    public Terrain[] getNeighborTerrains() {
        return nextTerrains.toArray(new Terrain[0]);
    }

    enum status {
        FREE, BLOCKED, VILLAGE, CITY
    }

    private IPoint point;

    private final List<Intersection> nextIntersections = new ArrayList<>();
    private final List<Path> nextPaths = new ArrayList<>();
    private final List<Terrain> nextTerrains = new ArrayList<>();

    private Player owner = null;

    private static int idCounter = 0;
    private final int id = idCounter++;

    public Intersection(IPoint point) {
        this.point = point;
    }

    void addNeighbor(Path next) {
        if (!nextPaths.contains(next)) {
            for (Path p : nextPaths) {
                next.addNeighbor(p);
                p.addNeighbor(next);
            }
            nextPaths.add(next);
        }
    }

    void addNeighbor(Intersection next) {
        if (!nextIntersections.contains(next)) {
            nextIntersections.add(next);
        }
    }

    void addNeighbor(Terrain next) {
        if (!nextTerrains.contains(next)) {
            nextTerrains.add(next);
        }
    }

    @Override
    public String toString() {
        return "Intersection | ID: " + id + " | " + point;
    }

}

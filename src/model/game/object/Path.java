package model.game.object;


import model.game.IIntersection;
import model.game.IPath;

import java.util.ArrayList;
import java.util.List;

public class Path implements IPath{

    private final Intersection[] intersections;
    private final List<Path> nextPaths = new ArrayList<>();

    private static int idCounter = 0;
    private final int id = idCounter++;

    private Player owner = null;

    public Path(Intersection... intersections) {
        assert (intersections.length == 2);
        this.intersections = intersections;
        intersections[0].addNeighbor(this);
        intersections[1].addNeighbor(this);
        intersections[0].addNeighbor(intersections[1]);
        intersections[1].addNeighbor(intersections[0]);
    }

    public void addNeighbor(Path next) {
        if(!nextPaths.contains(next)) {
            nextPaths.add(next);
        }

    }

    public Intersection getIntersection(int index) {
        return intersections[index];
    }


    @Override
    public String toString() {
        return "Path | ID: " + id + " | " + intersections[0].getId() + " " + intersections[1].getId();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public IIntersection[] getIntersections() {
        return intersections.clone();
    }
}

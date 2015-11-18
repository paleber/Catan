package game;

import geo.IPoint;
import util.IdGenerator;

public class Intersection {

    private final int id = IdGenerator.generate();

    private IPoint p;

    private Intersection[] nextIntersections;
    private Path[] nextPaths;

    private Player owner;

}

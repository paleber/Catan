package game;

import util.IdGenerator;

public class Terrain {

    private final int id = IdGenerator.generate();

    private int number; // 2-6, 8-12
    private Material type;
    private Intersection[] intersections;

}

package model;

import util.IdGenerator;

public class Terrain {

    private final int id = IdGenerator.generate();

    private int number; // 2-6, 8-12
    private TerrainType type;
    private Intersection[] intersections;

}

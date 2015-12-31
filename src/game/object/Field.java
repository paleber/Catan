package game.object;

import util.IdGenerator;

public class Field {

    private final int id = IdGenerator.generate();

    private int number; // 2-6, 8-12
    private Material material;
    private Intersection[] intersections;



}

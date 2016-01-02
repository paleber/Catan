package game.object;


import geo.IPolygon;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private static final int NO_NUMBER = -1;

    private int number; // 2-6, 8-12
    private Material terrain;
    private IPolygon poly;
    private final List<Intersection> nextIntersections = new ArrayList<>();

    public Field(IPolygon poly, int number, Material terrain) {
        this.poly = poly;
        this.number = number;
        this.terrain = terrain;
    }

    public Field(IPolygon poly, Material terrain) {
        this(poly, NO_NUMBER, terrain);
    }

    public void addNeighbor(Intersection intersection) {
        nextIntersections.add(intersection);
    }

    public String toString() {
        return "Field: " + poly.calculateMid() + " " + number + " "  + terrain;


    }


}

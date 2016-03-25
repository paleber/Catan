package model.game.object;


import geo.IPolygon;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private static final int NO_NUMBER = -1;
    private final Intersection[] intersections;

    private int number; // 2-6, 8-12
    private Material terrain;

    private static int idCounter = 0;
    private final int id = idCounter++;

    public Field(Material terrain, int number, Intersection... intersections) {
        assert (intersections.length == 6);
        this.intersections = intersections;
        this.number = number;
        this.terrain = terrain;
        for(Intersection inter: intersections) {
            inter.addNeighbor(this);
        }

    }

    public String toString() {
        return "Field: TODO " + number + " " + terrain;


    }


}

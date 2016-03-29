package model.game.object;


import model.game.IIntersection;
import model.game.ITerrain;
import model.game.Material;
import model.game.event.IGameEvent;
import model.game.event.SetupTerrainEvent;

import java.util.Set;

public class Terrain implements ITerrain {

    private static final int NO_NUMBER = -1;
    private final Intersection[] intersections;

    private int number; // 2-6, 8-12
    private Material material;

    private static int idCounter = 0;
    private final int id = idCounter++;

    public Terrain(Material material, int number, Intersection... intersections) {
        assert (intersections.length == 6);
        this.intersections = intersections;
        this.number = number;
        this.material = material;
        for (Intersection inter : intersections) {
            inter.addNeighbor(this);
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public IIntersection[] getIntersections() {
        return intersections.clone();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Terrain | ID: " + id + " | Number: " + number + " | Material: " + material);
        for (Intersection i : intersections) {
            builder.append(" " + i.getId());
        }
        return builder.toString();
    }

    public SetupTerrainEvent createSetupEvent() {
        return new SetupTerrainEvent(id, number, material,
                intersections[0].getId(), intersections[1].getId(),
                intersections[2].getId(), intersections[3].getId(),
                intersections[4].getId(), intersections[5].getId());
    }

}

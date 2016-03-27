package model.game.event;

import model.game.Material;

public class SetupTerrainEvent implements IGameEvent {

    public final int ID;

    public final int NUMBER;

    public final Material MATERIAL;

    public final int[] INTERSECTION_IDS;

    public SetupTerrainEvent(int id, int number, Material material, int... intersectionIds) {
        assert (intersectionIds.length == 6);
        this.ID = id;
        this.NUMBER = number;
        this.MATERIAL = material;
        this.INTERSECTION_IDS = intersectionIds;
    }

}

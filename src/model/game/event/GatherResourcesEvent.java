package model.game.event;

import model.game.Material;

public class GatherResourcesEvent implements IGameEvent {

    public final int PLAYER_ID;

    public final int WAYPOINT_ID;

    public final int TERRAIN_ID;

    public final Material MATERIAL;

    public final int MATERIAL_COUNT;

    public GatherResourcesEvent(int playerId, int waypointId, int terrainId, Material material, int materialCount) {
        this.PLAYER_ID = playerId;
        this.WAYPOINT_ID = waypointId;
        this.TERRAIN_ID = terrainId;
        this.MATERIAL = material;
        this.MATERIAL_COUNT = materialCount;
    }

}

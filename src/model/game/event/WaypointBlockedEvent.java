package model.game.event;

public final class WaypointBlockedEvent implements IGameEvent {

    public final int WAYPOINT_ID;

    public WaypointBlockedEvent(int waypointId) {
        this.WAYPOINT_ID = waypointId;
    }

}

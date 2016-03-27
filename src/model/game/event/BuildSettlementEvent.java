package model.game.event;

public class BuildSettlementEvent implements IGameEvent {

    public final int PLAYER_ID;
    public final int INTERSECTION_ID;

    public BuildSettlementEvent(int playerId, int intersectionId) {
        this.PLAYER_ID = playerId;
        this.INTERSECTION_ID = intersectionId;
    }

}

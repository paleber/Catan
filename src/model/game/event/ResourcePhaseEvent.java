package model.game.event;

public class ResourcePhaseEvent implements IGameEvent {

    public final int PLAYER_ID;

    public ResourcePhaseEvent(int playerId) {
        this.PLAYER_ID = playerId;
    }

}

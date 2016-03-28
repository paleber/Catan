package model.game.event;

public class NextPlayerEvent implements IGameEvent {

    public final int PLAYER_ID;

    public NextPlayerEvent(int playerId) {
        this.PLAYER_ID = playerId;
    }

}

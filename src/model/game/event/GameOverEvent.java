package model.game.event;

public final class GameOverEvent implements IGameEvent {

    public final int PLAYER_ID;

    public GameOverEvent(final int playerId) {
        this.PLAYER_ID = playerId;
    }

}

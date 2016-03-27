package model.game.event;

public class PreparationPhaseSettlementEvent implements IGameEvent {

    public final int PLAYER_ID;

    public PreparationPhaseSettlementEvent(int playerId) {
this.PLAYER_ID = playerId;
    }
}

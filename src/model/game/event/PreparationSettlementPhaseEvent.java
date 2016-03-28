package model.game.event;

public class PreparationSettlementPhaseEvent implements IGameEvent {

    public final int PLAYER_ID;

    public PreparationSettlementPhaseEvent(int playerId) {
this.PLAYER_ID = playerId;
    }
}

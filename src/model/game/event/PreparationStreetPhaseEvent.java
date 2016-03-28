package model.game.event;

public class PreparationStreetPhaseEvent implements IGameEvent {

    public final int INTERSECTION_ID;

    public PreparationStreetPhaseEvent(int intersectionId) {
        this.INTERSECTION_ID = intersectionId;
    }

}

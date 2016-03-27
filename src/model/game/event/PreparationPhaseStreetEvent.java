package model.game.event;

public class PreparationPhaseStreetEvent implements IGameEvent {

    public final int INTERSECTION_ID;

    public PreparationPhaseStreetEvent(int intersectionId) {
        this.INTERSECTION_ID = intersectionId;
    }

}

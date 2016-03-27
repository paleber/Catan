package model.game.event;

public class SetupPathEvent implements IGameEvent {

    public final int ID;

    public final int[] INTERSECTION_IDS;

    public SetupPathEvent(int id, int... intersectionIds) {
        assert (intersectionIds.length == 2);
        this.ID = id;
        this.INTERSECTION_IDS = intersectionIds;
    }

}

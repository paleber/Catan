package model.game.event;

public class SetupIntersectionEvent implements IGameEvent {

    public final double ID;

    public final double X;

    public final double Y;

    public SetupIntersectionEvent(int id, double x, double y) {
        this.ID = id;
        this.X = x;
        this.Y = y;
    }

}

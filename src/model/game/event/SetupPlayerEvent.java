package model.game.event;

import java.awt.Color;

public class SetupPlayerEvent implements IGameEvent {

    public final int ID;

    public final String NAME;

    public final Color COLOR;

    public SetupPlayerEvent(int id, String name, Color color) {
        this.ID = id;
        this.NAME = name;
        this.COLOR = color;
    }
    
}

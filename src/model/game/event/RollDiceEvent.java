package model.game.event;

public class RollDiceEvent implements IGameEvent{

    public final int[] NUMBERS;

    public RollDiceEvent(int... numbers) {
        assert (numbers.length == 2);
        this.NUMBERS = numbers;
    }

}

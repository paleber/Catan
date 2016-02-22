package tui.menu;

import engine.text_cmd.ITextCommand;


public abstract class TextCommand implements ITextCommand {

    private String[] args;
    private int index;

    @Override
    public void execute(String... args) throws IndexOutOfBoundsException, NumberFormatException {
        this.args = args;
        index = 1;
        execute();
    }

    protected final String parseString() throws IndexOutOfBoundsException {
        return args[index++];
    }

    protected final int parseInteger() throws IndexOutOfBoundsException, NumberFormatException {
        return Integer.parseInt(args[index++]);
    }

    protected abstract void execute() throws IndexOutOfBoundsException, NumberFormatException;

}

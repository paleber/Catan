package engine.text_cmd;

/**
 * TextCommand for putting as value into Map, with command as Key.
 */
public interface ITextCommand {

    /**
     * Execute the command.
     *
     * @param args argument list, including command at args[0]
     * @throws IndexOutOfBoundsException not enough arguments
     * @throws NumberFormatException illegal argument format
     */
    void execute(String... args) throws IndexOutOfBoundsException, NumberFormatException;

    /**
     * Get the description of the command.
     *
     * @return description description.
     */
    String getDescription();

}

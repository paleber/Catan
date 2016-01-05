package engine.text_command;

/** TextCommand for putting as value into Map, with command as Key. */
public interface ITextCommand {

    /** Execute the command.
     * @param args argument list, including command at args[0] */
    void execute(String... args);

    /** Get the description of the command.
     * @return description description.*/
    String getDescription();

}

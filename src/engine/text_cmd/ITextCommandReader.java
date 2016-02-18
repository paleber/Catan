package engine.text_cmd;

public interface ITextCommandReader {

    void addCommand(String name, ITextCommand cmd);

    void clearCommands();

    void shutdown();

}

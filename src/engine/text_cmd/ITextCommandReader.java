package engine.text_cmd;

public interface ITextCommandReader {

    void start();

    void addCommand(String name, ITextCommand cmd);

    void clearCommands();

    void shutdown();

}

package tui;

import com.google.inject.Inject;
import engine.console.IConsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CommandParser {

    @Inject private IConsole console;

    public CommandParser() {




        // neuen Thread starten, der einliest


    }


    public void trigger() {

    }


/*

    private void readLine() {
        String line = console.readLine();
        if (line != null) {
            String[] words = line.split(" ");
            TextCommand cmd = cmdMap.get(words[0]);
            if (cmd != null) {
                cmd.execute(words);
            } else {
                LOGGER.info("unknown command, \"help\" to print"
                        + " available commands");
            }
        }
    }


*/

}

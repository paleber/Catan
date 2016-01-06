package model.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;


public final class PlayerData {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final int MIN_NUMBER_PLAYER = 1;
    public static final int MAX_NUMBER_PLAYER = 4;

    private final List<String> names = new LinkedList<>();

    public PlayerData() {
        resizeList(MIN_NUMBER_PLAYER);
    }

    public void setNumberPlayers(int n)  {
        if (n < MIN_NUMBER_PLAYER || n > MAX_NUMBER_PLAYER) {
            LOGGER.error(String.format("Only %d to %d players allowed",
                    MIN_NUMBER_PLAYER, MAX_NUMBER_PLAYER));
            return;
        }
        resizeList(n);
    }

    private void resizeList(int n) {
        while (names.size() < n) {
            names.add("Player" + (names.size() + 1));
        }
        while (names.size()> n) {
            names.remove(names.size() - 1);
        }
    }

    public void setPlayerName(String name, int index) {

        if (names.contains(name)) {
            LOGGER.error("Name already in use");
            return;
        }

        if (!checkName(name)) {
            LOGGER.error("Name contains illegal characters");
            return;
        }

        try {
            names.remove(index);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error("Player not exist");
            return;
        }

        names.add(index, name);
    }

    public String[] getPlayerNames() {
        return names.toArray(new String[names.size()]);
    }

    private boolean checkName(String name) {
        if (name.contains(" ")) {
            return false;
        }
        // TODO more checks like length, illegal characters and numbers
        return true;
    }

}

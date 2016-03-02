package model.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public final class PlayerData {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final int MIN_NUMBER_PLAYER = 1;
    public static final int MAX_NUMBER_PLAYER = 4;

    public static final int MIN_NAME_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 20;

    private final List<String> names = new LinkedList<>();

    /*
    public PlayerData() {
        resizeList(MIN_NUMBER_PLAYER);
    } */

    /*
    public void setNumberOfPlayers(int n) {
        if (n < MIN_NUMBER_PLAYER || n > MAX_NUMBER_PLAYER) {
            throw new IllegalNumberOfPlayersException(n);
        }
       // resizeList(n);
    } */

    /*
    private void resizeList(int n) {
        while (names.size() < n) {
            names.add("Player" + (names.size() + 1));
        }
        while (names.size() > n) {
            names.remove(names.size() - 1);
        }
    } */



    public String[] getPlayerNames() {
        return names.toArray(new String[names.size()]);
    }

    public void addPlayer(String name) {
        if (names.contains(name)) {
            throw new NameAlreadyInUseException(name);
        }

        if (!name.matches("^[\\p{Alpha}]{" + MIN_NAME_LENGTH + "," + MAX_NAME_LENGTH + "}$")) {
            throw new IllegalNameException(name);
        }

        names.add(name);
    }

    public void removePlayer(String name) {
        if (!names.contains(name)) {
            throw new PlayerNotExistException(name);
        }
        names.remove(name);
    }

    public final static class IllegalNumberOfPlayersException extends RuntimeException {
        public IllegalNumberOfPlayersException(final int number) {
            super(String.format("%d is invalid, only %d to %d players allowed",
                    number, PlayerData.MIN_NUMBER_PLAYER, PlayerData.MAX_NUMBER_PLAYER));
        }
    }

    public final static class NameAlreadyInUseException extends RuntimeException {
        public NameAlreadyInUseException(final String name) {
            super("Name already in use: " + name);
        }
    }

    public final static class IllegalNameException extends RuntimeException {
        public IllegalNameException(final String name) {
            super("Invalid player name: " + name);
        }
    }

    public final static class PlayerNotExistException extends RuntimeException {
        public PlayerNotExistException(final String name) {
            super("Player " + name + " not exists");
        }
    }

}

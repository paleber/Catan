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

    public PlayerData() {
        resizeList(MIN_NUMBER_PLAYER);
    }

    public void setNumberOfPlayers(int n) {
        if (n < MIN_NUMBER_PLAYER || n > MAX_NUMBER_PLAYER) {
            throw new IllegalNumberOfPlayersException(n);
        }
        resizeList(n);
    }

    private void resizeList(int n) {
        while (names.size() < n) {
            names.add("Player" + (names.size() + 1));
        }
        while (names.size() > n) {
            names.remove(names.size() - 1);
        }
    }

    public void setPlayerName(String name, int index) {
        if (names.contains(name)) {
            throw new NameAlreadyInUseException(name);
        }

        if (!name.matches("^[\\p{Alpha}]{" + MIN_NAME_LENGTH + "," + MAX_NAME_LENGTH + "}$")) {
            throw new IllegalNameException(name);
        }

        try {
            names.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new PlayerNotExistException(index);
        }

        names.add(index, name);
    }

    public String[] getPlayerNames() {
        return names.toArray(new String[names.size()]);
    }

    public final static class IllegalNumberOfPlayersException extends RuntimeException {
        public IllegalNumberOfPlayersException(final int number) {
            super(String.format("%d is invalid, only %d to %d players allowed",
                    PlayerData.MIN_NUMBER_PLAYER, PlayerData.MAX_NUMBER_PLAYER));
        }
    }

    public final static class NameAlreadyInUseException extends RuntimeException {
        public NameAlreadyInUseException(final String name) {
            LOGGER.error("Name already in use: " + name);
        }
    }

    public final static class IllegalNameException extends RuntimeException {
        public IllegalNameException(final String name) {
            LOGGER.error("Invalid player name: " + name);
        }
    }

    public final static class PlayerNotExistException extends RuntimeException {
        public PlayerNotExistException(final int index) {
            LOGGER.error(String.format("Player with index %d not exists, only %d to %d players exists",
                    index, MIN_NUMBER_PLAYER, MAX_NUMBER_PLAYER));
        }
    }

}

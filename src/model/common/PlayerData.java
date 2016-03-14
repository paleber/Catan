package model.common;

import control.exception.IllegalNameException;
import control.exception.IllegalNumberOfPlayersException;
import control.exception.NameInUseException;
import control.exception.PlayerNotExistsException;
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

    public String[] getPlayerNames() {
        return names.toArray(new String[names.size()]);
    }

    public void addPlayer(String name) throws NameInUseException, IllegalNameException {

        if (names.size() >= MAX_NUMBER_PLAYER) {
            throw new IllegalNumberOfPlayersException(MIN_NUMBER_PLAYER, MAX_NUMBER_PLAYER);
        }

        if (names.contains(name)) {
            throw new NameInUseException(name);
        }

        if (!name.matches("^[\\p{Alpha}]{" + MIN_NAME_LENGTH + "," + MAX_NAME_LENGTH + "}$")) {
            throw new IllegalNameException(name);
        }

        names.add(name);
    }

    public void removePlayer(String name) throws PlayerNotExistsException {
        if (!names.contains(name)) {
            throw new PlayerNotExistsException(name);
        }
        names.remove(name);
    }

    public void checkStartConditions() throws IllegalNumberOfPlayersException {
        if (names.size() < MIN_NUMBER_PLAYER) {
            throw new IllegalNumberOfPlayersException(MIN_NUMBER_PLAYER, MAX_NUMBER_PLAYER);
        }
    }
}

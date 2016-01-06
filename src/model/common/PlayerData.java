package model.common;

import java.util.LinkedList;
import java.util.List;

import static model.common.CatanException.*;

public final class PlayerData {

    public static final int MIN_NUMBER_PLAYER = 1;
    public static final int MAX_NUMBER_PLAYER = 4;

    private final List<String> names = new LinkedList<>();

    public PlayerData() {
        resizeList(MIN_NUMBER_PLAYER);
    }

    public void setNumberPlayers(int n) throws IllegalPlayerNumberException {
        if (n < MIN_NUMBER_PLAYER || n > MAX_NUMBER_PLAYER) {
            throw new IllegalPlayerNumberException();
        }
    }

    private void resizeList(int n) {
        while (names.size() < n) {
            names.add("Player" + (names.size() + 1));
        }
        while (names.size()> n) {
            names.remove(names.size() - 1);
        }

    }

    public void setPlayerName(String name, int index)
            throws PlayerNotExistsException, NameAlreadyInUseException, IllegalNameException {

        if (names.contains(name)) {
            throw new NameAlreadyInUseException();
        }

        if (!checkName(name)) {
            throw new IllegalNameException();
        }

        try {
            names.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new PlayerNotExistsException();
        }

        names.add(index, name);
    }

    public String[] getPlayerNames() {
        return names.toArray(new String[0]);
    }

    private boolean checkName(String name) {
        if (name.contains(" ")) {
            return false;
        }
        // TODO more checks like length, illegal characters and numbers
        return true;
    }

}

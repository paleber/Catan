package model.game.object;

import java.util.EnumMap;
import java.util.Map;

public class Player {

    private static final int MAX_STREETS = 15;
    private static final int MAX_VILLAGES = 5;
    private static final int MAX_CITIES = 4;



    private Map<Material, Integer> resources = new EnumMap<>(Material.class);

    public Player(String name) {
        for (Material m : Material.values()) {
            if (m.isCollectable()) {
                resources.put(m, 0);
            }
        }
    }

    public void addMaterial(Material m) {
        int n = resources.remove(m);
        resources.put(m, n + 1);
    }

    public int getMaterialNumber(Material m) {
        return resources.get(m);
    }

    public String getName() {
        return "PlayerName"; //TODO
    }

    public boolean buildStreet(Intersection inter) { return false;}

    public boolean buildCity() {return false; }

    public boolean buildVillage() { return false;}

}

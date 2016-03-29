package model.game.object;

import com.google.common.collect.ImmutableMap;
import control.exception.game.NotEnoughMaterialException;
import control.game.IGameControl;
import model.game.Material;
import model.game.event.GatherResourcesEvent;
import model.game.event.SetupPlayerEvent;

import java.awt.Color;
import java.util.*;

public class Player {

    private static final int MAX_STREETS = 15;
    private static final int MAX_SETTLEMENTS = 5;
    private static final int MAX_CITIES = 4;

    private final IGameControl control;
    private final Game game;

    private final int id;


    private Map<Material, Integer> resources = new EnumMap<>(Material.class);

    private final List<Path> streets = new LinkedList<>();
    private final List<Intersection> settlements = new LinkedList<>();
    private final List<Intersection> cities = new LinkedList<>();

    private static final Map<Material, Integer> streetCosts = new TreeMap<>();
    private static final Map<Material, Integer> settlementCosts = new TreeMap<>();
    private static final Map<Material, Integer> cityCosts = new TreeMap<>();

    private static final ImmutableMap<Material, Integer> m = ImmutableMap.of(Material.BRICK, 1, Material.LUMBER, 1);


    static {

        streetCosts.put(Material.BRICK, 1);
        streetCosts.put(Material.LUMBER, 1);

        settlementCosts.put(Material.BRICK, 1);
        settlementCosts.put(Material.LUMBER, 1);
        settlementCosts.put(Material.GRAIN, 1);
        settlementCosts.put(Material.WOOL, 1);

        cityCosts.put(Material.GRAIN, 2);
        cityCosts.put(Material.ORE, 3);
    }


    public Player(String name, int id, Color color, IGameControl control, Game game) {
        for (Material m : Material.values()) {
            if (m.isCollectable()) {
                resources.put(m, 0);
            }
        }

        this.id = id;
        this.control = control;
        this.game = game;

        control.sendGameEvent(new SetupPlayerEvent(id, name, color));
    }

    private void checkCosts(Map<Material, Integer> costs) {
        for (Material m : costs.keySet()) {
            if (resources.get(m) < costs.get(m)) {
                throw new NotEnoughMaterialException("TODO");
            }
        }
    }

    void collectMaterial(int number) {

        for (Intersection s : settlements) {
            for (Terrain t : s.getNeighborTerrains()) {
                if (t.getNumber() == number) {
                    int n = resources.get(t.getMaterial());
                    resources.put(t.getMaterial(), n + 1);
                    control.sendGameEvent(new GatherResourcesEvent(id, s.getId(), t.getId(), t.getMaterial(), 1));
                }
            }
        }

        for (Intersection s : cities) {
            for (Terrain t : s.getNeighborTerrains()) {
                if (t.getNumber() == number) {
                    int n = resources.get(t.getMaterial());
                    resources.put(t.getMaterial(), n + 2);
                    control.sendGameEvent(new GatherResourcesEvent(id, s.getId(), t.getId(), t.getMaterial(), 2));
                }
            }
        }

    }

    public void countWinPoints(int playerId) {
        game.gameOver(playerId);
    }





    /*
    private void addMaterial(Material m) {
        int n = resources.remove(m);
        resources.put(m, n + 1);
    }

    public int getMaterialNumber(Material m) {
        return resources.get(m);
    } */


    public void buildSettlement(Intersection s) {
        // TODO
    }

    public void buildStreet(Path s) {
        // TODO
    }

    public void buildSetupSettlement(Intersection s) {
        // TODO
    }

    public void buildSetupStreet(Path path) {
        // TODO
    }

    public void collectStartResources() {
        // TODO
    }

    public void buildCity(int waypointId) {
        // TODO
    }

    public Intersection[] getSettlements() {
        return new Intersection[]{}; // TODO
    }
}

package model.game.object;

import control.game.IGameControl;
import model.game.IIntersection;
import model.game.IPath;
import model.game.IPlayer;
import model.game.Material;
import model.game.event.SetupPlayerEvent;
import model.game.event.SetupTerrainEvent;

import java.awt.*;
import java.util.EnumMap;
import java.util.Map;

public class Player implements IPlayer {

    private static final int MAX_STREETS = 15;
    private static final int MAX_VILLAGES = 5;
    private static final int MAX_CITIES = 4;
    private final IGameControl control;

    private Map<Material, Integer> resources = new EnumMap<>(Material.class);

    public Player(String name, Color color, IGameControl control) {
        for (Material m : Material.values()) {
            if (m.isCollectable()) {
                resources.put(m, 0);
            }
        }

        this.color = color;
        this.control = control;
    }

    public void collectStartMaterial() {

    }

    public void collectMaterial(int number) {

    }

    public void countWinPoints() {

    }

    int id = 0;
    String name = "TODO";
    private final Color color ;

    public SetupPlayerEvent createSetupEvent() {
        return new SetupPlayerEvent(id, name, color);
    }

    /*
    private void addMaterial(Material m) {
        int n = resources.remove(m);
        resources.put(m, n + 1);
    }

    public int getMaterialNumber(Material m) {
        return resources.get(m);
    } */

    public String getName() {
        return "PlayerName"; //TODO
    }

    @Override
    public IPath[] getStreets() {
        return new IPath[0]; // TODO
    }

    @Override
    public IIntersection[] getSettlements() {
        return new IIntersection[0];  // TODO
    }

    @Override
    public IIntersection[] getCities() {
        return new IIntersection[0];  // TODO
    }

    @Override
    public Map<Material, Integer> getMaterials() {
        return resources; // TODO clone map
    }

    public Color getColor() {
        return Color.BLACK; // TODO
    }

    public void buildSettlement(Intersection s) {
        // TODO, in Vorbereitungsphase prüfen, dass korrekt gebaut wird

        // TODO, Material prüfen, wenn nicht genug vorhanden exception werfen
    }

    public void buildStreet(Path s) {
        // TODO, in Vorbereitungsphase prüfen, dass korrekt gebaut wird

        // TODO, Material prüfen, wenn nicht genug vorhanden exception werfen
    }

    public void buildSetupSettlement(Intersection s) {
        // TODO
    }

    public void buildSetupPath(Path path) {
        // TODO
    }

    public void gatherStartResources() {
        // TODO

    }
}

package model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class Player {

    private static final int MAX_STREETS = 15;
    private static final int MAX_VILLAGES = 5;
    private static final int MAX_CITIES = 4;

    private ArrayList<Intersection> cities;
    private ArrayList<Intersection> villages;
    private ArrayList<Path> streets;

    private Map<TerrainType, Integer> resources = new EnumMap<>(TerrainType.class);

    public void init(String[] args) {
        for (TerrainType t : TerrainType.values()) {
            if (t.isCollectable()) {
                resources.put(t, 0);
            }
        }
    }

}

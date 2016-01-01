package game.board;

import com.google.inject.Guice;
import game.object.Field;
import game.object.Material;
import game.object.Intersection;
import game.object.Path;
import geo.*;
import geo.imp.GeoModule;

import java.util.*;
import java.util.List;

public final class StandardBoardBuilder implements IBoardBuilder {

    private static final IGeoFactory GEO = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);

    private List<IPolygon> polys;


    private final Map<ILine, Path> paths = new TreeMap<>();
    private final Map<IPoint, Intersection> intersections = new TreeMap<>();

    private static final Map<Integer, Integer> NUMBER_COUNT = new TreeMap<>();

    static {
        NUMBER_COUNT.put(2, 1);
        NUMBER_COUNT.put(3, 2);
        NUMBER_COUNT.put(4, 2);
        NUMBER_COUNT.put(5, 2);
        NUMBER_COUNT.put(6, 2);
        NUMBER_COUNT.put(8, 2);
        NUMBER_COUNT.put(9, 2);
        NUMBER_COUNT.put(10, 2);
        NUMBER_COUNT.put(11, 2);
        NUMBER_COUNT.put(12, 1);
    }

    private static final Map<Material, Integer> TERRAIN_COUNT = new HashMap<>();

    static {
        TERRAIN_COUNT.put(Material.SAND, 1);
        TERRAIN_COUNT.put(Material.LUMBER, 4);
        TERRAIN_COUNT.put(Material.BRICK, 3);
        TERRAIN_COUNT.put(Material.WOOL, 4);
        TERRAIN_COUNT.put(Material.GRAIN, 4);
        TERRAIN_COUNT.put(Material.ORE, 3);
    }

    public StandardBoardBuilder() {
        HexagonBuilder builder = new HexagonBuilder();
        polys = builder.buildCore();
        builder.addRing(polys);
        builder.addRing(polys);
        getLines();
        getPoints();

        createPaths();
        createIntersections();
        createFields();
    }

    private void getLines() {
        for (IPolygon poly : polys) {
            for (ILine l : poly.iterateLines()) {
                if (!paths.containsKey(l)) {
                    paths.put(l, null);
                }
            }
        }
    }

    private void getPoints() {
        for (IPolygon poly : polys) {
            for (IPoint p : poly.iteratePoints()) {
                if (!intersections.containsKey(p)) {
                    intersections.put(p, null);
                }
            }
        }
    }

    private void createPaths() {
        // Create paths
        for (ILine line : paths.keySet()) {
            paths.put(line, new Path(line));
        }

        // Add neighbor paths
        for (ILine line : paths.keySet()) {
            for (ILine next : paths.keySet()) {
                if (line == next) {
                    continue;
                }

                if (line.getStart() == next.getStart() || // TODO Method in Line
                        line.getStart() == next.getEnd() ||
                        line.getEnd() == next.getStart() ||
                        line.getEnd() == next.getEnd()) {
                    paths.get(line).addNeighbor(paths.get(next));
                }
            }
            paths.put(line, new Path(line));
        }
    }


    private void createIntersections() {
        // Create intersections
        for (IPoint point : intersections.keySet()) {
            intersections.put(point, new Intersection(point));
        }

        // Add neighbor intersections
        for (IPoint point : intersections.keySet()) {
            // TODO Method in line containsPoint(): boolean
            paths.keySet().stream().filter(next -> next.getStart() == point || next.getEnd() == point).forEach(next -> {  // TODO Method in line containsPoint(): boolean
                intersections.get(point).addNeighbor(intersections.get(next.getOtherPoint(point)));
                intersections.get(point).addNeighbor(paths.get(next));
            });
        }
    }

    // TODO implement Comparable in geo

    private void createFields() {

    }

    @Override
    public Intersection[] getIntersections() {
        return new Intersection[0];
    }

    @Override
    public Path[] getPaths() {
        return new Path[0];
    }

    @Override
    public Field[] getTerrains() {
        return new Field[0];
    }


    public static void main(String[] args) {
        StandardBoardBuilder x = new StandardBoardBuilder();
        System.out.println("Polys: " + x.polys.size()); // 19
        System.out.println("Lines: " + x.paths.size()); // 72
        System.out.println("Points: " + x.intersections.size()); // 54

    }
}

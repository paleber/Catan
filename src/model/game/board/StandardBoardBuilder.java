package model.game.board;

import model.game.object.Field;

import model.game.object.Intersection;
import model.game.object.Path;


public final class StandardBoardBuilder implements IBoardBuilder {

    @Override
    public Intersection[] getIntersections() {
        return new Intersection[0];
    }

    @Override
    public Path[] getPaths() {
        return new Path[0];
    }

    @Override
    public Field[] getFields() {
        return new Field[0];
    }


    /*
    private static final Map<Integer, Integer> NUMBER_COUNT = new HashMap<>();

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

    private final Map<ILine, Path> paths = new HashMap<>();
    private final Map<IPoint, Intersection> intersections = new HashMap<>();
    private final Map<IPolygon, Field> fields = new HashMap<>();

    public StandardBoardBuilder() {
        HexagonBuilder builder = new HexagonBuilder();
        List<IPolygon> polys = builder.buildCore();
        builder.addRing(polys);
        builder.addRing(polys);

        for(IPolygon poly: polys) {
            fields.put(poly, null);
        }

        getLines(polys);
        getPoints(polys);

        createPaths();
        createIntersections();
        createFields();
    }

    private void getLines(List<IPolygon> polys) { // TODO read from map
        for (IPolygon poly : polys) {
            for (ILine l : poly.iterateLines()) {
                if (!paths.containsKey(l)) {
                    paths.put(l, null);
                }
            }
        }
    }

    private void getPoints(List<IPolygon> polys) { // TODO read from map
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

                if ( line.contains(next.getStart()) || line.contains(next.getEnd()) ) {
                    paths.get(line).addNeighbor(paths.get(next));
                }
            }
            paths.put(line, new Path(line));
        }
    }

    private void createIntersections() {
        // create intersections
        for (IPoint point : intersections.keySet()) {
            intersections.put(point, new Intersection(point));
        }

        // add neighbor intersections
        for (IPoint point : intersections.keySet()) {
            paths.keySet().stream().filter(next -> next.contains(point)).forEach(next -> {
                intersections.get(point).addNeighbor(intersections.get(next.getOtherPoint(point)));
                intersections.get(point).addNeighbor(paths.get(next));
            });
        }
    }

    private void createFields() {
        // create list with numbers
        List<Integer> numbers = new LinkedList<>();
        for (int key: NUMBER_COUNT.keySet()) {
            for (int i = 0; i < NUMBER_COUNT.get(key); i++) {
                numbers.add(key);
            }
        }

        // create list with terrain
        List<Material> terrains = new LinkedList<>();
        for (Material key: TERRAIN_COUNT.keySet()) {
            for (int i = 0; i < TERRAIN_COUNT.get(key); i++) {
                terrains.add(key);
            }
        }

        Random r = new Random();
        for(IPolygon key: fields.keySet()) {
            Material terrain = terrains.remove(r.nextInt(terrains.size()));
            if (terrain.isCollectable()) {
                int number = numbers.remove(r.nextInt(numbers.size()));
                fields.put(key, new Field(key, number, terrain));
            } else {
                fields.put(key, new Field(key, terrain));
            }
        }

    }

    @Override
    public Intersection[] getIntersections() {
        return intersections.values().toArray(new Intersection[0]);
    }

    @Override
    public Path[] getPaths() {
        return paths.values().toArray(new Path[0]);
    }

    @Override
    public Field[] getFields() {
        return fields.values().toArray(new Field[0]);
    }

    public static void main(String[] args) {
        StandardBoardBuilder x = new StandardBoardBuilder();
        System.out.println("Polys: " + x.fields.size()); // 19
        System.out.println("Lines: " + x.paths.size()); // 72
        System.out.println("Points: " + x.intersections.size()); // 54

        for(Field f: x.getFields()) {
            System.out.println(f);
        }
    }
*/
}

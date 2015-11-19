package game;

import com.google.inject.Guice;
import geo.*;
import geo.imp.GeoModule;

import java.util.*;

final class StandardBoardBuilder implements IBoardBuilder {

    private static final IGeoFactory GEO_FACTORY = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);

    @Override
    public void build() {

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
    public Terrain[] getTerrains() {
        return new Terrain[0];
    }

    enum Direction {
        C1, C3, C5, C7, C9, C11 // Direction, Number equals Clock-Position
    }

    private static final IPolygon PROTO_HEXAGON = createHexagon();

    private static final Map<Direction, IVector> dirs = createDirections();

    private static IPolygon createHexagon() {
        IPoint p = GEO_FACTORY.createPoint(0, 0);
        IVector[] v = new IVector[5];
        v[0] = GEO_FACTORY.createVector(1, 0);
        for (int i = 1; i < v.length; i++) {
            v[i] = GEO_FACTORY.copy(v[i - 1]);
            v[i].rotate(Math.PI / 3);
        }
        IPolygon hexagon = GEO_FACTORY.createPolygon(p, v);

        IPoint mid = GEO_FACTORY.createPoint(hexagon.getXMid(),
                hexagon.getYMid());
        IVector u = GEO_FACTORY.createVector(mid,
                GEO_FACTORY.createPoint(0, 0));
        hexagon.move(u);

        hexagon.rotate(GEO_FACTORY.createPoint(0,0), Math.PI / 6);

        return hexagon;
    }

    private static Map<Direction, IVector> createDirections() {
        Map<Direction, IVector> map = new TreeMap<>();
        IPoint from = GEO_FACTORY.createPoint(PROTO_HEXAGON.getXMid(),
                PROTO_HEXAGON.getYMid());
        for (ILine l : PROTO_HEXAGON.iterateLines()) {
            IPoint to = GEO_FACTORY.createPoint(l.getXMid(), l.getYMid());
            IVector v = GEO_FACTORY.createVector(from, to);
            v.setLength(2 * v.getLength());
            Direction dir = Direction.values()[map.size()];
            map.put(dir, v);
        }

        return map;
    }

    private List<Material> materials = initMaterials();

    private List<Material> initMaterials() {
        List<Material> mats = new LinkedList<>();

        for (int i = 0; i < 4; i++) {
            mats.add(Material.LUMBER);
        }
        for (int i = 0; i < 3; i++) {
            mats.add(Material.BRICK);
        }
        for (int i = 0; i < 4; i++) {
            mats.add(Material.WOOL);
        }
        for (int i = 0; i < 4; i++) {
            mats.add(Material.GRAIN);
        }
        for (int i = 0; i < 3; i++) {
            mats.add(Material.ORE);
        }

        // shuffle list
        Random r = new Random();
        for (int i = mats.size() - 1; i >= 0; i--) {
            Material m = mats.remove(r.nextInt(i));
            mats.add(m);
        }

        mats.add(Material.SAND);
        return mats;
    }

    private List<IPolygon> fields = new LinkedList<>();

    StandardBoardBuilder() {
        buildFields();
    }

    private void buildFields() {
        fields.add(GEO_FACTORY.copy(PROTO_HEXAGON));
        addField(Direction.C9);
        addField(Direction.C9);
        addField(Direction.C7);
        addField(Direction.C7);
        addField(Direction.C5);
        addField(Direction.C5);
        addField(Direction.C3);
        addField(Direction.C3);
        addField(Direction.C1);
        addField(Direction.C1);
        addField(Direction.C11);
        addField(Direction.C9);
        addField(Direction.C9);
        addField(Direction.C7);
        addField(Direction.C5);
        addField(Direction.C3);
        addField(Direction.C1);
        addField(Direction.C9);
    }

    private void addField(Direction dir) {
        IPolygon poly = GEO_FACTORY.copy(fields.get(fields.size() - 1));
        poly.move(dirs.get(dir));
        fields.add(poly);
    }


}




package game.board;

import com.google.inject.Guice;
import game.object.Field;
import game.object.Material;
import game.object.Intersection;
import game.object.Path;
import geo.*;
import geo.imp.GeoModule;


import java.util.*;

public final class StandardBoardBuilder implements IBoardBuilder {

    private static final IGeoFactory GEO = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);

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



    private static final IPolygon PROTO_HEXAGON = createHexagon();

    private static final Map<Direction, IVector> dirs = createDirections();

    private static IPolygon createHexagon() {
        IPoint p = GEO.createPoint(0, 0);
        IVector[] v = new IVector[5];
        v[0] = GEO.createVector(1, 0);
        for (int i = 1; i < v.length; i++) {
            v[i] = GEO.copy(v[i - 1]);
            v[i].rotate(Math.PI / 3);
        }
        IPolygon hexagon = GEO.createPolygon(p, v);

        IPoint mid = hexagon.calculateMid();
        IVector u = GEO.createVector(mid, GEO.createPoint(0, 0));
        hexagon.move(u);

        hexagon.rotate(GEO.createPoint(0,0), Math.PI / 6);

        return hexagon;
    }

    private static Map<Direction, IVector> createDirections() {
        Map<Direction, IVector> map = new TreeMap<>();
        IPoint from = PROTO_HEXAGON.calculateMid();
        for (ILine l : PROTO_HEXAGON.iterateLines()) {
            IPoint to = l.calculateMid();
            IVector v = GEO.createVector(from, to);
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
        fields.add(GEO.copy(PROTO_HEXAGON));
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
        IPolygon poly = GEO.copy(fields.get(fields.size() - 1));
        poly.move(dirs.get(dir));
        fields.add(poly);
    }


}




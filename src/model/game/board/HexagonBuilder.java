package model.game.board;

import com.google.inject.Guice;
import geo.*;
import geo.imp.GeoModule;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Build a Board of Hexagons.
 */
final class HexagonBuilder {

    private static final int NUMBER_CORNERS = 6;
    private static final double ANGLE = 2 * Math.PI / 3;

    private static final IGeoFactory GEO = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);
    private static final double DELTA = 1e-9;

    enum Direction {
        C1, C3, C5, C7, C9, C11 //Clock-Position
    }

    private static final IPolygon PROTO_HEXAGON = createHexagon();

    private static final Map<Direction, IVector> dirs = createDirections();


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

    public List<IPolygon> buildCore(Direction... directions) {
        List<IPolygon> polys = new LinkedList<>();
        polys.add(GEO.copy(PROTO_HEXAGON));

        for (Direction d: directions) {
            // TODO
        }

        return polys;
    }

    private static IPolygon createHexagon() {
        IPoint p = GEO.createPoint(0, 0);
        IVector[] v = new IVector[NUMBER_CORNERS - 1];
        v[0] = GEO.createVector(0, 1);
        for (int i = 1; i < v.length; i++) {
            v[i] = GEO.copy(v[i - 1]);
            v[i].rotate(2 * Math.PI / NUMBER_CORNERS);
        }
        IPolygon hexagon = GEO.createPolygon(p, v);

        // Move to zero
        IPoint mid = hexagon.calculateMid();
        IVector u = GEO.createVector(mid, GEO.createPoint(0, 0));
        hexagon.move(u);

        return hexagon;
    }

    public void addRing(List<IPolygon> polys) {
        int size = polys.size();
        for(int i = 0; i < size; i++) {
            for(IPoint p: polys.get(i).iteratePoints()) {
                for(int j = 0; j < 3; j++) {
                    IPolygon copy = GEO.copy(polys.get(i));
                    copy.rotate(p, j * ANGLE);

                    IPoint mid = copy.calculateMid();
                    boolean ok = true;
                    for(IPolygon poly: polys) {
                        if(poly.calculateMid().squareDistanceTo(mid) < DELTA * DELTA) {
                            ok = false;
                            break;
                        }
                    }
                    if(ok) {
                        for(IPolygon poly: polys) {
                            poly.mergePointsAndLines(copy, DELTA);

                        }
                        polys.add(copy);
                    }
                }
            }
        }
    }
}

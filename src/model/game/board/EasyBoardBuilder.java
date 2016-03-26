package model.game.board;

import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import model.game.object.Terrain;
import model.game.object.Intersection;
import model.game.Material;
import model.game.object.Path;

import java.util.*;

public class EasyBoardBuilder implements IBoardBuilder {

    private final Map<IPoint, Intersection> map = new HashMap<>();

    private final List<Path> paths = new LinkedList<>();
    private final List<Terrain> terrains = new LinkedList<>();

    public EasyBoardBuilder() {

        // create Intersection
        for (IPoint p : Coordinates.points) {
            map.put(p, new Intersection(p));
        }

        // create Paths
        for (ILine l : Coordinates.lines) {
            paths.add(new Path(map.get(l.getStart()), map.get(l.getEnd())));
        }

        // create Hexagons
        for (IPolygon poly : Coordinates.polys) {
            Intersection[] inter = new Intersection[poly.getNumberElements()];
            for (int i = 0; i < inter.length; i++) {
                inter[i] = map.get(poly.getPoint(i));
            }
            terrains.add(new Terrain(Material.LUMBER, 8, inter));
        }

    }

    @Override
    public Intersection[] getIntersections() {
        Intersection[] a = new Intersection[map.values().size()];
        for (int i = 0; i < a.length; i++) {
            for (Intersection inter : map.values()) {
                if (inter.getId() == i) {
                    a[i] = inter;
                    break;
                }
            }
        }
        return a;
    }

    @Override
    public Path[] getPaths() {
        return paths.toArray(new Path[0]);
    }

    public Terrain[] getTerrains() {
        return terrains.toArray(new Terrain[0]);
    }

}

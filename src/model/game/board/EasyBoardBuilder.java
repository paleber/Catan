package model.game.board;

import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import model.game.object.Field;
import model.game.object.Intersection;
import model.game.object.Material;
import model.game.object.Path;

import java.util.*;

/**
 * Created by Patrick on 25.03.2016.
 */
public class EasyBoardBuilder implements IBoardBuilder{


    //Intersection[] intersection = new Intersection[Coordinates.points.length];

    private final SortedMap<IPoint, Intersection> map = new TreeMap<>();

    private final List<Path> paths = new LinkedList<>();
    private final List<Field> fields = new LinkedList<>();


    public EasyBoardBuilder() {

        // create Intersection
        for(IPoint p: Coordinates.points) {
            map.put(p, new Intersection(p));
        }

        // create Paths
        for(ILine l: Coordinates.lines) {
            paths.add(new Path(map.get(l.getStart()), map.get(l.getEnd())));
        }

        // create Hexagons
        for(IPolygon poly: Coordinates.polys) {
            Intersection[] inter = new Intersection[poly.getNumberElements()];
            for(int i = 0; i < inter.length; i++) {
                inter[i] = map.get(poly.getPoint(i));
            }
            fields.add(new Field(Material.LUMBER, 8, inter));
        }

        // add nextPaths to Intersections
        for(Path path: paths) {
            path.getIntersection(0).addNeighbor(path);
        }

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
    public Field[] getFields() {
        return new Field[0];
    }
}

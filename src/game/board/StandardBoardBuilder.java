package game.board;

import com.google.inject.Guice;
import game.object.Field;
import game.object.Material;
import game.object.Intersection;
import game.object.Path;
import geo.*;
import geo.imp.GeoModule;


import java.awt.*;
import java.util.*;
import java.util.List;

public final class StandardBoardBuilder implements IBoardBuilder {

    private static final IGeoFactory GEO = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);


    private List<IPolygon> polys;
    private List<ILine> lines = new LinkedList<>();
    private List<IPoint> points = new LinkedList<>();

    public StandardBoardBuilder() {
        HexagonBuilder builder = new HexagonBuilder();
        polys = builder.buildCore();
        builder.addRing(polys);
        builder.addRing(polys);
        getLines();
        getPoints();
    }


    private void getLines() {
       for(IPolygon poly: polys) {
           for(ILine l: poly.iterateLines()) {
               if(!lines.contains(l)) {
                   lines.add(l);
               }
           }
       }
    }

    private void getPoints() {
        for(IPolygon poly: polys) {
            for(IPoint p: poly.iteratePoints()) {
                if(!points.contains(p)) {
                    points.add(p);
                }
            }
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
    public Field[] getTerrains() {
        return new Field[0];
    }







   // private List<Material> materials = initMaterials();

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
/*
    StandardBoardBuilder() {
        buildFields();
    }*/

    /*
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
    }*/

    /*
    private void addField(Direction dir) {
        IPolygon poly = GEO.copy(fields.get(fields.size() - 1));
        poly.move(dirs.get(dir));
        fields.add(poly);
    }
*/

    public static void main(String[] args) {
        StandardBoardBuilder x = new StandardBoardBuilder();
        System.out.println("Polys: " + x.polys.size()); // 19
        System.out.println("Lines: " + x.lines.size()); // 72
        System.out.println("Points: " + x.points.size()); // 54

    }
}




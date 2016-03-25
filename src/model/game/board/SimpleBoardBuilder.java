package model.game.board;

import com.google.inject.Guice;
import com.google.inject.Injector;
import geo.IGeoFactory;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;
import geo.imp.GeoModule;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Patrick on 25.03.2016.
 */
public class SimpleBoardBuilder {

    private static final Injector INJ = Guice.createInjector(new GeoModule());
    private static final double DELTA = 1e-9;

    IGeoFactory geo = INJ.getInstance(IGeoFactory.class);


    private final List<IPolygon> list = new LinkedList<>();
    private final List<IPoint> points = new LinkedList<>();

    public SimpleBoardBuilder() {
        list.add(createStartPoly());
        multiplyAll();
        multiplyAll();

        for(IPolygon poly: list) {
            for(IPoint p: poly.iteratePoints()) {
                addPoint(p);
            }
        }
        System.out.println(points.size());
        System.out.println(points);


        for(int i = 0; i < points.size(); i++) {
            System.out.printf(Locale.ENGLISH, "points[%d] = geo.createPoint(%.3f, %.3f);%n", i, points.get(i).getX(), points.get(i).getY());
            //System.out.println("points[" + i + "] = geo.createPoint(" + points.get(i).getX() + ", " + points.get(i).getX() + ");");
        }

       // points[0] = geo.createPoint(0.866,-0.500);

    }

    private void addPoint(IPoint p) {

        for(IPoint q: points) {
            if(q.distanceTo(p) < DELTA) {
                return;
            }
        }
        points.add(p);

    }


    IPolygon start = createStartPoly();

    private IPolygon createStartPoly() {
        IPoint s = geo.createPoint(0, 0);
        IVector[] v = new IVector[5];
        v[0] = geo.createVector(0, 1);
        for (int i = 1; i < v.length; i++) {
            v[i] = geo.copy(v[i - 1]);
            v[i].rotate(Math.PI / 3);
        }
        IPolygon p = geo.createPolygon(s, v);

        IVector diff = geo.createVector(p.calculateMid(), s);
        p.move(diff);

        return p;
    }

    private void multiplyAll() {
        int n = list.size();
        for(int i = 0; i < n; i++) {
            multiplySingle(list.get(i));
        }
    }

    private void multiplySingle(IPolygon poly) {
        for(IPoint p: poly.iteratePoints()) {
            for(int i = 1; i <= 2; i++) {
                IPolygon copy = geo.copy(poly);
                copy.rotate(p, 2*i* (Math.PI / 3));
                list.add(copy);
            }
        }


    }


    public static void main(String[] args) {


        System.out.println(new SimpleBoardBuilder().createStartPoly());
    }
}

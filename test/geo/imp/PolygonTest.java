package geo.imp;

import geo.ILine;
import geo.IPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PolygonTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testAddPoint() {
        Polygon poly = new Polygon();
        poly.addPoint(2, 1);
        poly.addPoint(3, 5);
        Vector v = new Vector();
        v.init(2, 3);
        poly.addPoint(v);

        int i = 0;
        for (IPoint p : poly.iteratePoints()) {
            if (i == 0) {
                assertEquals(2, p.getX(), DELTA);
                assertEquals(1, p.getY(), DELTA);
            } else if (i == 1) {
                assertEquals(3, p.getX(), DELTA);
                assertEquals(5, p.getY(), DELTA);
            } else {
                assertEquals(5, p.getX(), DELTA);
                assertEquals(8, p.getY(), DELTA);
            }
            i++;
        }
    }

    @Test
    public void testCopy() {
        Polygon poly = new Polygon();
        poly.addPoint(1, 2);
        poly.addPoint(7, 8);
        poly.addPoint(6, 5);

        Polygon copy = new Polygon();
        copy.copy(poly);

        int i = 0;
        for (IPoint p : copy.iteratePoints()) {
            if (i == 0) {
                assertEquals(1, p.getX(), DELTA);
                assertEquals(2, p.getY(), DELTA);
            } else if (i == 1) {
                assertEquals(7, p.getX(), DELTA);
                assertEquals(8, p.getY(), DELTA);
            } else {
                assertEquals(6, p.getX(), DELTA);
                assertEquals(5, p.getY(), DELTA);
            }
            i++;
        }
    }

    @Test
    public void testBoundingBox() {
        Polygon poly = new Polygon();
        poly.addPoint(8, 3);
        poly.addPoint(4, 7);
        poly.addPoint(5, 4);

        Vector v = new Vector();
        v.init(1, 1);

        poly.move(v);

        assertEquals(5, poly.getXMin(), DELTA);
        assertEquals(9, poly.getXMax(), DELTA);
        assertEquals(4, poly.getYMin(), DELTA);
        assertEquals(8, poly.getYMax(), DELTA);
    }

    @Test
    public void testRotate() {
        Polygon poly = new Polygon();
        poly.addPoint(0, 0);
        poly.addPoint(1, 2);
        poly.addPoint(1, 1);

        Point pivot = new Point(0, 0);
        poly.rotate(pivot, Math.PI);

        int i = 0;
        for (IPoint p : poly.iteratePoints()) {
            if (i == 1) {
                assertEquals(-1, p.getX(), DELTA);
                assertEquals(-2, p.getY(), DELTA);
            }
            i++;
        }
    }

    @Test
    public void testToString() {
        Polygon poly = new Polygon();
        poly.addPoint(0, 1);
        poly.addPoint(2, 3);
        poly.addPoint(4, 5);
        assertEquals("<(0.000|1.000)(2.000|3.000)(4.000|5.000)>", poly.toString());
    }

    @Test
    public void testLines() {
        Polygon poly = new Polygon();
        poly.addPoint(0, 0);
        poly.addPoint(1, 1);
        poly.addPoint(2, 3);

        int i = 0;
        for (ILine l : poly.iterateLines()) {
            if (i == 0) {
                assertEquals(0, l.getStart().getX(), DELTA);
                assertEquals(0, l.getStart().getY(), DELTA);
                assertEquals(1, l.getEnd().getX(), DELTA);
                assertEquals(1, l.getEnd().getY(), DELTA);
            } else if (i == 1) {
                assertEquals(1, l.getStart().getX(), DELTA);
                assertEquals(1, l.getStart().getY(), DELTA);
                assertEquals(2, l.getEnd().getX(), DELTA);
                assertEquals(3, l.getEnd().getY(), DELTA);
            } else {
                assertEquals(2, l.getStart().getX(), DELTA);
                assertEquals(3, l.getStart().getY(), DELTA);
                assertEquals(0, l.getEnd().getX(), DELTA);
                assertEquals(0, l.getEnd().getY(), DELTA);
            }
            i++;
        }
    }
}

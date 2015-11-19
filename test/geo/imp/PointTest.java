package geo.imp;

import geo.IVector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    private static final double DELTA = 1e-9;

    @Test
    public void testConstructorDefault() {
        Point p = new Point(0 ,0);
        assertEquals(0, p.getX(), DELTA);
        assertEquals(0, p.getY(), DELTA);
    }

    @Test
    public void testConstructorValue() {
        Point p = new Point(3, 5);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(5, p.getY(), DELTA);
    }

    @Test
    public void testConstructorCopy() {
        Point p = new Point(7, 5);
        Point q = new Point(p);
        assertEquals(7, q.getX(), DELTA);
        assertEquals(5, q.getY(), DELTA);
    }

    @Test
    public void testGetter() {
        Point p = new Point(3, 4);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(4, p.getY(), DELTA);
    }

    @Test
    public void testMove() {
        IVector v = new Vector(2, 5);
        Point p = new Point(1, 2);
        p.move(v);
        assertEquals(3, p.getX(), DELTA);
        assertEquals(7, p.getY(), DELTA);
    }

    @Test
    public void testRotate() {
        Point q = new Point(1, 1);
        Point p = new Point(0, 0);

        p.rotate(q, 0.5 * Math.PI);
        assertEquals(2, p.getX(), DELTA);
        assertEquals(0, p.getY(), DELTA);

        p.rotate(q, 2.5 * Math.PI);
        assertEquals(2, p.getX(), DELTA);
        assertEquals(2, p.getY(), DELTA);

        p.rotate(q, -3.5 * Math.PI);
        assertEquals(0, p.getX(), DELTA);
        assertEquals(2, p.getY(), DELTA);
    }

    @Test
    public void toStringTest() {
        Point p = new Point(7, 8);
        assertEquals("(7.000|8.000)", p.toString());
    }

}

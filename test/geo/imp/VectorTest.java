package geo.imp;

import geo.IVector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    private final IVector v = new Vector();
    private static final double DELTA = 1e-9;

    @Test
    public void testInit() {
        v.init(5, 3);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void testCopy() {
        IVector u = new Vector();
        u.init(1, 3);

        v.copy(u);
        assertEquals(1, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void testStretch() {
        Point p = new Point(-2, -1);
        Point q = new Point(3, 2);

        v.stretch(p, q);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(3, v.getY(), DELTA);
    }

    @Test
    public void testGetter() {
        v.init(5, 2);
        assertEquals(5, v.getX(), DELTA);
        assertEquals(2, v.getY(), DELTA);
    }

    @Test
    public void testLength() {
        v.init(0, 2);
        assertEquals(2, v.getLength(), DELTA);

        v.setLength(3);
        assertEquals(3, v.getLength(), DELTA);
    }

    @Test
    public void testRotateAndAngle() {
        v.init(1, 0);
        v.rotate(0.25 * Math.PI);
        assertEquals(0.25 * Math.PI, v.getAngle(), DELTA);

        v.rotate(-1.5 * Math.PI);
        assertEquals(0.75 * Math.PI, v.getAngle(), DELTA);

        v.rotate(6.5 * Math.PI);
        assertEquals(1.25 * Math.PI, v.getAngle(), DELTA);
    }

    @Test
    public void testToString() {
        v.init(2, 3);
        assertEquals("<2.000|3.000>", v.toString());
    }

}

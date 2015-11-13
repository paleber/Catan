package geo.imp;

import geo.IPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {

    private static final double DELTA = 1e-9;

    private static final Point p = new Point(2, 3);
    private static final Point q = new Point(4, 5);
    private static final Line l = new Line(p, q);

    @Test
    public void testBoundingBox() {
        assertEquals(2, l.getXMin(), DELTA);
        assertEquals(3, l.getYMin(), DELTA);
        assertEquals(4, l.getXMax(), DELTA);
        assertEquals(5, l.getYMax(), DELTA);
    }

    /*
    @Test
    public void testIterable() {
        for(int i = 0; i < 2; i++) {
            int j = 0;
            for (IPoint n : l.iteratePoints()) {
                if (j == 0) {
                    assertEquals(p, n);
                } else {
                    assertEquals(q, n);
                }
                j++;
            }
        }
    } */

    @Test
    public void testGetter() {
        assertEquals(2, l.getStart().getX(), DELTA);
        assertEquals(3, l.getStart().getY(), DELTA);
        assertEquals(4, l.getEnd().getX(), DELTA);
        assertEquals(5, l.getEnd().getY(), DELTA);
    }

    @Test
    public void testToString() {
        assertEquals("<(2.000|3.000)(4.000|5.000)>", l.toString());
    }

}

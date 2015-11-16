package geo.imp;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Implementation of Polygon. */
final class Polygon implements IPolygon {

    private final Point[] points;
    private final Line[] lines;

    private double xMin, yMin, xMax, yMax;

    private final Iterable<IPoint> pointIterator =
            () -> new Iterator<IPoint>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return i < points.length;
                }

                @Override
                public IPoint next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return points[i++];
                }
            };

    private final Iterable<ILine> lineIterator =
            () -> new Iterator<ILine>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return i < lines.length;
                }

                @Override
                public ILine next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return lines[i++];
                }
            };

    @Inject
    Polygon(@Assisted final IPoint... p) {
        points = (Point[]) p.clone();
        lines = new Line[points.length];
        initLines();
    }


    @Inject
    Polygon(@Assisted final IPoint p, @Assisted final IVector... v) {
        points = new Point[1 + v.length];
        points[0] = (Point) p;
        for (int i = 0; i < v.length; i++) {
            points[i + 1] = new Point(points[i]);
            points[i + 1].move(v[i]);
        }
        lines = new Line[points.length];
        initLines();
    }

    @Inject
    Polygon(@Assisted final IPolygon other) {
        Polygon poly = (Polygon) other;
        points = new Point[poly.points.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(poly.points[i]);
        }
        lines = new Line[points.length];
        initLines();
    }

    private void initLines() {
        for (int i = 0; i < points.length; i++) {
            lines[i] = new Line(points[i], points[(i + 1) % points.length]);
        }
        update();
    }

    @Override
    public void move(final IVector v) {
        for (Point p : points) {
            p.move(v);
        }
        update();
    }

    @Override
    public void rotate(final IPoint pivot, final double radian) {
        for (Point p : points) {
            p.rotate(pivot, radian);
        }
        update();
    }

    @Override
    public double getXMin() {
        return xMin;
    }

    @Override
    public double getYMin() {
        return yMin;
    }

    @Override
    public double getXMax() {
        return xMax;
    }

    @Override
    public double getYMax() {
        return yMax;
    }

    @Override
    public double getXMid() {
        return (xMin + xMax) / 2;
    }

    @Override
    public double getYMid() {
        return (yMin + yMax) / 2;
    }

    private void update() {
        xMin = points[0].getX();
        yMin = points[0].getY();
        xMax = points[0].getX();
        yMax = points[0].getY();
        for (int i = 1; i < points.length; i++) {
            xMin = Math.min(xMin, points[i].getX());
            yMin = Math.min(yMin, points[i].getY());
            xMax = Math.max(xMax, points[i].getX());
            yMax = Math.max(yMax, points[i].getY());
        }
    }

    @Override
    public Iterable<IPoint> iteratePoints() {
        return pointIterator;
    }

    @Override
    public Iterable<ILine> iterateLines() {
        return lineIterator;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("<");
        for (Point p : points) {
            b.append(p);
        }
        b.append(">");
        return b.toString();
    }

}

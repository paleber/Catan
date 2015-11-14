package geo.imp;

import geo.ILine;
import geo.IPoint;

/** Implementation of Line. */
final class Line implements ILine {

    private final Point end;
    private final Point start;

    Line(final Point start, final Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public double getXMin() {
        return Math.min(start.getX(), end.getX());
    }

    @Override
    public double getYMin() {
        return Math.min(start.getY(), end.getY());
    }

    @Override
    public double getXMax() {
        return Math.max(start.getX(), end.getX());
    }

    @Override
    public double getYMax() {
        return Math.max(start.getY(), end.getY());
    }

    @Override
    public String toString() {
        return "<" + start + end + ">";
    }

    @Override
    public IPoint getStart() {
        return start;
    }

    @Override
    public IPoint getEnd() {
        return end;
    }
}

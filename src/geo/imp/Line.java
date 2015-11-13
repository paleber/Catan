package geo.imp;

import geo.ILine;
import geo.IPoint;

final class Line implements ILine {

    private final Point[] points = new Point[2];

    Line(Point s, Point e) {
        points[0] = s;
        points[1] = e;
    }

    @Override
    public double getXMin() {
        return Math.min(points[0].getX(), points[1].getX());
    }

    @Override
    public double getYMin() {
        return Math.min(points[0].getY(), points[1].getY());
    }

    @Override
    public double getXMax() {
        return Math.max(points[0].getX(), points[1].getX());
    }

    @Override
    public double getYMax() {
        return Math.max(points[0].getY(), points[1].getY());
    }

    @Override
    public String toString() {
        return "<" + points[0] + points[1] + ">";
    }

    @Override
    public IPoint getStart() {
        return points[0];
    }

    @Override
    public IPoint getEnd() {
        return points[1];
    }
}

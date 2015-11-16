package geo.imp;

import geo.IPoint;
import geo.IVector;

import java.util.Locale;

final class Point implements IPoint {

    private double x, y;

    Point() {
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(Point other) {
        x = other.x;
        y = other.y;
    }

    /*
    void init(double x, double y) {
        this.x = x;
        this.y = y;
    }*/

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double squareDistanceTo(final IPoint other) {
        return (x * x) + (y * y);
    }

    void move(final IVector v) {
        x += v.getX();
        y += v.getY();
    }

    void rotate(final IPoint pivot, final double radian) {
        x -= pivot.getX();
        y -= pivot.getY();

        double sin = Math.sin(radian);
        double cos = Math.cos(radian);

        double xn = x * cos - y * sin;
        double yn = x * sin + y * cos;

        x = xn + pivot.getX();
        y = yn + pivot.getY();
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "(%.3f|%.3f)", getX(), getY());
    }

}

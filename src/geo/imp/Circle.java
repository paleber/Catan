package geo.imp;

import geo.ICircle;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

/** Implementation of Circle. */
final class Circle implements ICircle {

    /* Mid of the circle. */
    private final Point mid = new Point();

    /* Radius of the circle. */
    private double radius;

    @Override
    public void init(final double x, final double y, final double radius) {
        mid.init(x, y);
        this.radius = radius;
    }

    @Override
    public void move(final IVector v) {
        mid.move(v);
    }

    @Override
    public void rotate(final IPoint pivot, final double radian) {
        mid.rotate(pivot, radian);
    }

    @Override
    public double getXMin() {
        return mid.getX() - radius;
    }

    @Override
    public double getYMin() {
        return mid.getY() - radius;
    }

    @Override
    public double getXMax() {
        return mid.getX() + radius;
    }

    @Override
    public double getYMax() {
        return mid.getY() + radius;
    }

    @Override
    public double getXMid() {
        return mid.getX();
    }

    @Override
    public double getYMid() {
        return mid.getY();
    }

    @Override
    public IPoint getMid() {
        return mid;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "<%sr=%.3f>", mid.toString(),
                             radius);
    }

}

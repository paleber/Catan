package geo.imp;

import geo.ICircle;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

final class Circle implements ICircle{

    private final Point mid = new Point();
    private double radius;

    @Override
    public void init(double x, double y, double radius) {
        mid.x = x;
        mid.y = y;
        this.radius = radius;
    }

    @Override
    public void move(IVector v) {
        mid.move(v);
    }

    @Override
    public void rotate(IPoint pivot, double radian) {
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
    public IPoint getMid() {
        return mid;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "<%sr=%.3f>", mid.toString(), radius);
    }

}

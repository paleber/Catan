package geo.imp;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import com.google.inject.assistedinject.AssistedInject;
import geo.ICircle;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

/** Implementation of Circle. */
final class Circle implements ICircle {

    private final Point mid;
    private final double radius;

    @AssistedInject
    Circle(@Assisted final IPoint mid, @Assisted final double radius) {
        this.mid = (Point) mid;
        this.radius = radius;
    }

    @AssistedInject
    Circle(@Assisted final ICircle other) {
        mid = new Point(other.getMid());
        radius = other.getRadius();
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

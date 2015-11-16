package geo.imp;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

/** Implementation of Point. */
final class Point implements IPoint {

    private double x, y;

    @Inject
    Point(@Assisted final double x, @Assisted final double y) {
        this.x = x;
        this.y = y;
    }

    @Inject
    Point(@Assisted final IPoint other) {
        x = other.getX();
        y = other.getY();
    }

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

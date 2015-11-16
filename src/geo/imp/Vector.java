package geo.imp;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

/** Implementation of Vector. */
final class Vector implements IVector {

    private double radian, length;

    @Inject
    Vector(@Assisted final double x, @Assisted final double y) {
        radian = Math.atan2(y, x);
        length = Math.sqrt(x * x + y * y);
        limitAngle();
    }

    @Inject
    Vector(@Assisted final IVector other) {
        radian = other.getAngle();
        length = other.getLength();
    }

    @Inject
    Vector(@Assisted final IPoint start, @Assisted final IPoint end) {
        this(end.getX() - start.getX(), end.getY() - start.getY());
    }

    @Override
    public double getX() {
        return Math.cos(radian) * length;
    }

    @Override
    public double getY() {
        return Math.sin(radian) * length;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getAngle() {
        return radian;
    }

    @Override
    public void setLength(final double length) {
        this.length = length;
    }

    @Override
    public void rotate(final double radian) {
        this.radian += radian;
        limitAngle();
    }

    private void limitAngle() {
        radian = radian % (2 * Math.PI);
        if (radian < 0) {
            radian += 2 * Math.PI;
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "<%.3f|%.3f>", getX(), getY());
    }
}

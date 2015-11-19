package geo.imp;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import geo.IPoint;
import geo.IVector;

import java.util.Locale;

/** Implementation of Vector. */
final class Vector implements IVector {

    private double radian, length;

    @AssistedInject
    Vector(@Assisted("x") final double x, @Assisted("y") final double y) {
        radian = Math.atan2(y, x);
        length = Math.sqrt(x * x + y * y);
        limitAngle();
    }

    @AssistedInject
    Vector(@Assisted final IVector other) {
        radian = other.getAngle();
        length = other.getLength();
    }

    @AssistedInject
    Vector(@Assisted("f") final IPoint from, @Assisted("t") final IPoint to) {
        this(to.getX() - from.getX(), to.getY() - from.getY());
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

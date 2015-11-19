package geo.imp;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import geo.ILine;
import geo.IPoint;

/** Implementation of Line. */
final class Line implements ILine {

    private final Point start;
    private final Point end;

    @AssistedInject
    Line(@Assisted("s") final IPoint start, @Assisted("e") final IPoint end) {
        this.start = (Point) start;
        this.end = (Point) end;
    }

    @AssistedInject
    Line(@Assisted final ILine other) {
        start = new Point(other.getStart());
        end = new Point(other.getEnd());
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
    public double getXMid() {
        return (start.getX() + end.getX()) / 2;
    }

    @Override
    public double getYMid() {
        return (start.getY() + end.getY()) / 2;
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

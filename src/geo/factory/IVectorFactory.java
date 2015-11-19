package geo.factory;

import geo.IPoint;
import geo.IVector;

public interface IVectorFactory {
    /**
     * Create a vector.
     *
     * @param x x-value
     * @param y y-value
     * @return created vector
     */
    IVector createVector(double x, double y);

    /**
     * Create a vector between two points .
     *
     * @param from from
     * @param to   to
     * @return created vector
     */
    IVector createVector(IPoint from, IPoint to);

    /**
     * Copy a vector.
     *
     * @param v vector to copy
     * @return created vector
     */
    IVector copy(IVector v);
}

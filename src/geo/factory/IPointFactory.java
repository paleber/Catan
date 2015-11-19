package geo.factory;

import geo.IPoint;

public interface IPointFactory {
    /**
     * Create a new point.
     *
     * @param x x-value
     * @param y y-value
     * @return created point
     */
    IPoint createPoint(double x, double y);

    /**
     * Copy a point.
     *
     * @param p point to copy
     * @return created point
     */
    IPoint copy(IPoint p);
}

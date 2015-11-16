package geo;

/**
 * Factory for GeoModule.
 */
public interface IGeoFactory {

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

    /**
     * Create a line.
     *
     * @param start start
     * @param end   end
     * @return created line.
     */
    ILine createLine(IPoint start, IPoint end);


    /**
     * Copy a line.
     *
     * @param l line to copy
     * @return created line
     */
    ILine copy(ILine l);

    /**
     * Create a circle.
     *
     * @param mid    mid
     * @param radius radius
     * @return created circle
     */
    ICircle createCircle(IPoint mid, double radius);

    /**
     * Copy a circle.
     *
     * @param c circle to copy
     * @return created circle
     */
    ICircle copy(ICircle c);

    /**
     * Create a polygon with corner-points.
     *
     * @param p points
     * @return created polygon
     */
    IPolygon createPolygon(IPoint... p);

    /**
     * Create a polygon by moving a point along vectors.
     *
     * @param p first point
     * @param v vectors to move
     * @return created polygon
     */
    IPolygon createPolygon(IPoint p, IVector... v);

    /**
     * Copy a polygon.
     *
     * @param poly polygon to copy
     * @return created polygon
     */
    IPolygon copy(IPolygon poly);

}

package geo.factory;

import geo.IPoint;
import geo.IPolygon;
import geo.IVector;

public interface IPolygonFactory {
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

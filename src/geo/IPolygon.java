package geo;

/**
 * Interface of Polygon.
 */
public interface IPolygon extends IShape {

    /**
     * Iterate through the points.
     *
     * @return point-iterator
     */
    Iterable<IPoint> iteratePoints();

    /**
     * Iterate through the lines.
     *
     * @return line-iterator
     */
    Iterable<ILine> iterateLines();

}

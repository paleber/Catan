package geo;

/**
 * Interface of Point.
 */
public interface IPoint {

    /**
     * Get the x-value.
     *
     * @return x-value
     */
    double getX();

    /**
     * Get the y-value.
     *
     * @return y-value
     */
    double getY();

    /**
     * Calculate the square-distance to an other point.
     *
     * @param other other point
     * @return square-distance
     */
    double squareDistanceTo(IPoint other);

}

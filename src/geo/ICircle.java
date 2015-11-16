package geo;

/**
 * Interface of Circle.
 */
public interface ICircle extends IShape {

    /**
     * Get the mid.
     *
     * @return mid
     */
    IPoint getMid();

    /**
     * Get the radius.
     *
     * @return radius
     */
    double getRadius();

}

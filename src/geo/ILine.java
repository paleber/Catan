package geo;

/**
 * Interface of Line.
 */
public interface ILine extends IBoundingBox {

    /**
     * Get the start.
     *
     * @return start
     */
    IPoint getStart();


    /**
     * Get the end.
     *
     * @return end
     */
    IPoint getEnd();

}

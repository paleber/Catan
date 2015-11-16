package geo;

/**
 * Interface of BoundingBox.
 */
interface IBoundingBox {

    /**
     * Get the minimum x-value.
     *
     * @return x-value.
     */
    double getXMin();

    /**
     * Get the minimum y-value.
     *
     * @return y-value.
     */
    double getYMin();

    /**
     * Get the maximum x-value.
     *
     * @return x-value.
     */
    double getXMax();

    /**
     * Get the maximum y-value.
     *
     * @return y-value.
     */
    double getYMax();

    /**
     * Get the middle x-value.
     *
     * @return x-value.
     */
    double getXMid();

    /**
     * Get the middle y-value.
     *
     * @return y-value.
     */
    double getYMid();

}

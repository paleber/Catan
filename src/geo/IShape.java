package geo;

/**
 * Interface of Shape.
 */
interface IShape extends IBoundingBox {


    /**
     * Move the Shape along a Vector.
     *
     * @param v Vector
     */
    void move(IVector v);

    /**
     * Rotate the Shape around a point.
     *
     * @param pivot  pivot
     * @param radian angle in radian
     */
    void rotate(IPoint pivot, double radian);

}

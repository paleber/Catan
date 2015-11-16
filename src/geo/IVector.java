package geo;

/**
 * Interface of Vector.
 */
public interface IVector {

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
     * Get the length.
     *
     * @return length
     */
    double getLength();

    /**
     * Get the angle.
     *
     * @return angle in radian
     */
    double getAngle();

    /**
     * Set the length.
     *
     * @param length length
     */
    void setLength(double length);

    /**
     * Rotate.
     *
     * @param radian angle in radian
     */
    void rotate(double radian);

}

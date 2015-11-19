package geo.factory;

import geo.ICircle;
import geo.IPoint;

public interface ICircleFactory {
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
}

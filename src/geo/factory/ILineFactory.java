package geo.factory;

import geo.ILine;
import geo.IPoint;

public interface ILineFactory {
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
}

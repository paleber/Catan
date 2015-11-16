package geo;

public interface IGeoFactory {

    IPoint createPoint(double x, double y);

    IVector createVector(double x, double y);

    IVector createVector(IPoint from, IPoint to);

    ILine createLine(IPoint start, IPoint end);

    ICircle createCircle(IPoint mid, double radius);

    IPolygon createPolygon(IPoint... p);

    IPolygon createPolygon(IPoint p, IVector... v);

    IPoint copy(IPoint p);

    IVector copy(IVector v);

    ILine copy(ILine l);

    ICircle copy(ICircle c);

    IPolygon copy(IPolygon poly);

}

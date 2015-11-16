package geo;

public interface IGeoFactory {

    IPoint createPoint(double x, double y);

    IPoint copy(IPoint p);

    IVector createVector(double x, double y);

    IVector createVector(IPoint from, IPoint to);

    IVector copy(IVector v);

    ILine createLine(IPoint start, IPoint end);

    ILine copy(ILine l);

    ICircle createCircle(IPoint mid, double radius);

    ICircle copy(ICircle c);

    IPolygon createPolygon(IPoint... p);

    IPolygon createPolygon(IPoint p, IVector... v);

    IPolygon copy(IPolygon poly);

}

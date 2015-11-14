package geo;

public interface ICircle extends IShape {

    void init(double x, double y, double radius);

    IPoint getMid();

    double getRadius();

}

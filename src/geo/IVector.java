package geo;

public interface IVector {

    void init(double x, double y);

    void copy(IVector other);

    void stretch(IPoint from, IPoint to);

    double getX();

    double getY();

    double getLength();

    double getAngle();
    
    void setLength(double length);
    
    void rotate(double radian);

}

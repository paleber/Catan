package geo;

public interface IVector {
    
    double getX();

    double getY();

    double getLength();

    double getAngle();
    
    void setLength(double length);
    
    void rotate(double radian);

}

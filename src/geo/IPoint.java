package geo;

public interface IPoint {

    double getX();

    double getY();

    double squareDistanceTo(IPoint other);

}

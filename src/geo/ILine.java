package geo;

public interface ILine extends IBoundingBox {

	//Iterable<IPoint> iteratePoints();

	IPoint getStart();
	IPoint getEnd();

}

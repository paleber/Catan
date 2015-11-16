package geo;

interface IShape extends IBoundingBox {

    void move(IVector v);

    void rotate(IPoint pivot, double radian);

}

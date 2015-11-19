package game;


abstract class AbstractBoardBuilder implements IBoardBuilder {

    /*private static final IGeoFactory GEO_FACTORY = Guice.createInjector(
            new GeoModule()).getInstance(IGeoFactory.class);

    private final Map<IPolygon, IPoint> polys = new TreeMap<>();

    private static final double DELTA = 1e-3;

    public AbstractBoardBuilder() {
        buildFirstPoly();
    }

    private void buildFirstPoly() {
        IPoint p = GEO_FACTORY.createPoint(0, 0);
        IVector[] v = new IVector[5];
        v[0] = GEO_FACTORY.createVector(1, 0);
        for (int i = 1; i < v.length; i++) {
            v[i] = GEO_FACTORY.copy(v[i-1]);
            v[i].rotate(Math.PI / 3);
        }
        addPoly(GEO_FACTORY.createPolygon(p, v));
    }

    private void addPoly(IPolygon poly) {
        IPoint mid = GEO_FACTORY.createPoint(poly.getXMid(), poly.getYMid());
        for (IPoint p: polys.values()) {
            if (mid.squareDistanceTo(p) < DELTA) {
               return;
            }
        }
        polys.put(poly, mid);
    }

*/



}

package geo.imp;

import com.google.inject.AbstractModule;
import geo.ICircle;
import geo.IPolygon;
import geo.IVector;

/** GeoModule. */
public final class GeoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IVector.class).to(Vector.class);
        bind(ICircle.class).to(Circle.class);
        bind(IPolygon.class).to(Polygon.class);
    }

}

package geo.imp;

import geo.*;
import com.google.inject.AbstractModule;

public final class GeoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IVector.class).to(Vector.class);
        bind(ICircle.class).to(Circle.class);
        bind(IPolygon.class).to(Polygon.class);
    }

}

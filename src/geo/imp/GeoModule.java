package geo.imp;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import geo.ICircle;
import geo.IGeoFactory;
import geo.ILine;
import geo.IPoint;
import geo.IPolygon;
import geo.IVector;

/** GeoModule. */
public final class GeoModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().
                implement(IPoint.class, Point.class).
                implement(IVector.class, Vector.class).
                implement(ILine.class, Line.class).
                implement(ICircle.class, Circle.class).
                implement(IPolygon.class, Polygon.class).
                build(IGeoFactory.class));
    }

}

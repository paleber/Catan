package geo.imp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import geo.ICircle;
import geo.IPolygon;
import geo.IVector;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class TestGeoModule {

    private static final Injector INJ = Guice.createInjector(new GeoModule());

    @Test
    public void testConfigure() {
        assertTrue(INJ.getInstance(IVector.class) != null);
        assertTrue(INJ.getInstance(IPolygon.class) != null);
        assertTrue(INJ.getInstance(ICircle.class) != null);
    }

}

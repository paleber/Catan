package geo.imp;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;


public class TestGeoModule {



    @Test
    public void testConfigure() {
        Injector inj = Guice.createInjector(new GeoModule());


    }

}

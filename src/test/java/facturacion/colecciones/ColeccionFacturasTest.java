package facturacion.colecciones;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.time.LocalDateTime;

/**
 * Created by user on 1/03/17.
 */
public class ColeccionFacturasTest {

    private static ColeccionFacturas facturas;

    @BeforeClass
    public static void init(){
        facturas=new ColeccionFacturas();
    }

    @AfterClass
    public static void end(){
        facturas=null;

    }
}

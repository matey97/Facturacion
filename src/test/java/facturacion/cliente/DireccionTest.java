package facturacion.cliente;

import facturacion.cliente.Direccion;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 28/02/17.
 */
public class DireccionTest {

    private static Direccion direccion;

    @BeforeClass
    public static void init(){
        direccion = new Direccion (12600,"Castellón", "La Vall d'Uixó");
    }

    @AfterClass
    public static void end(){
        direccion = null;
    }

    @Test
    public void getDireccionTest(){
        assertEquals(direccion.getDireccion(),"12600, La Vall d'Uixó, Castellón");
    }

    @Test
    public void toStringTest(){
        assertEquals(direccion.toString(),"12600, La Vall d'Uixó, Castellón");
    }

}

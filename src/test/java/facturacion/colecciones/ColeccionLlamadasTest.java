package facturacion.colecciones;

import facturacion.Excepciones.DuracionNoValida;
import facturacion.Excepciones.ExcepcionClienteSinLlamadas;
import facturacion.Utiles;
import facturacion.factura.Llamada;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 1/03/17.
 */
public class ColeccionLlamadasTest {

    private static ColeccionLlamadas llamadas;
    private static Llamada llamada1,llamada2,llamada3;

    @BeforeClass
    public static void init() throws DuracionNoValida{
        llamadas=new ColeccionLlamadas();
        llamada1=new Llamada(669318017, LocalDateTime.of(2017,1,2,0,0),13);
        llamada2=new Llamada(612317002, LocalDateTime.of(2017,2,1,0,0),5);
        llamada2=new Llamada(695968097, LocalDateTime.of(2017,3,1,0,0),24);
    }

    @AfterClass
    public static void end(){
        llamadas=null;
        llamada1=llamada2=llamada3=null;
    }

    @Test
    public void listarLlamadasTest() throws ExcepcionClienteSinLlamadas {
        llamadas.darDeAlta("100",llamada1);
        llamadas.darDeAlta("100",llamada2);
        llamadas.darDeAlta("200",llamada3);

        assertTrue(llamadas.listarLlamadas("100").contains(llamada1));
        assertTrue(llamadas.listarLlamadas("200").contains(llamada3));
        assertTrue(!llamadas.listarLlamadas("200").contains(llamada2));

    }

    @Test
    public void llamadasEntreDosFechasTest() throws ExcepcionClienteSinLlamadas{
        llamadas.darDeAlta("100",llamada1);
        llamadas.darDeAlta("100",llamada2);
        llamadas.darDeAlta("200",llamada3);
        assertTrue(Utiles.entreDosFechas(llamadas.listarLlamadas("100"),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,1,20,0,0)).contains(llamada1));
        assertTrue(!Utiles.entreDosFechas(llamadas.listarLlamadas("100"),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,1,20,0,0)).contains(llamada2));
        llamadas=new ColeccionLlamadas();
    }
}

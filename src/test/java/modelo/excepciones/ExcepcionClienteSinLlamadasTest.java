package modelo.excepciones;

import modelo.colecciones.ColeccionLlamadas;
import modelo.factura.Llamada;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

/**
 * Created by user on 26/03/17.
 */
public class ExcepcionClienteSinLlamadasTest {

    public static ColeccionLlamadas col;
    public static boolean lanzada;

    @BeforeClass
    public static void init() throws DuracionNoValida{
        col=new ColeccionLlamadas();
        col.darDeAlta("100", new Llamada(695968097, LocalDateTime.now(), 6));
        col.darDeAlta("100", new Llamada(695968097, LocalDateTime.now(), 5));
    }

    @Before
    public void antesDeTest(){
        lanzada=false;
    }

    @Test
    public void clientesSinLlamadasTest(){
        System.out.println("Se debería lanzar una excepción:");
        try{
            col.listarLlamadas("200");
        }catch(ExcepcionClienteSinLlamadas e){
            lanzada=true;
            System.out.println(e);
        }
        if(!lanzada)
            fail();
    }

    @Test
    public void clientesConLlamadasTest(){
        try{
            col.listarLlamadas("100");
        }catch(ExcepcionClienteSinLlamadas e){
            lanzada=true;
            System.out.println(e);
        }
        if(lanzada)
            fail();
    }
}

package facturacion.excepciones;

import facturacion.excepciones.PrecioTarifaNoValido;
import facturacion.factura.Tarifa;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by user on 26/03/17.
 */
public class PrecioTarifaNoValidoTest {

    public static Tarifa tarifa;
    public static boolean lanzada;

    @Before
    public void antesDeTest(){
        tarifa=null;
        lanzada=false;
    }

    @Test
    public void precioTarifaNoValidoTest(){
        System.out.println("Se debería lanzar una excepción:");
        try{
            tarifa=new Tarifa(-3);
        }catch (PrecioTarifaNoValido e){
            lanzada=true;
            System.out.println(e);
        }
        if(!lanzada)
            fail();
    }

    @Test
    public void precioTarifaValidoTest(){
        try{
            tarifa=new Tarifa(7);
        }catch (PrecioTarifaNoValido e){
            lanzada=true;
            System.out.println(e);
        }
        if(lanzada)
            fail();
    }
}

package facturacion.colecciones;

import facturacion.excepciones.PrecioTarifaNoValido;
import facturacion.Utiles;
import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Particular;
import facturacion.factura.Tarifa;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Created by user on 28/02/17.
 */
public class ColeccionParticularesTest { //Test de ColeccionParticulares

    private static ColeccionParticulares particulares;
    private static Cliente cliente1, cliente2;

    @BeforeClass
    public static void init() throws PrecioTarifaNoValido{
        cliente1=new Particular("Miguel","Matey Sanz","73402320M",new Direccion(12600,"Castellon","La Vall d'Uixó"),"al341802@uji.es", LocalDateTime.of(2017,2,1,0,0),new Tarifa(5));
        cliente2=new Particular("Sergio","Jimenez Chovares","53649080T", new Direccion(12567,"Castellon", "Castellon"),"al341933@uji.es",LocalDateTime.of(2017,4,1,0,0),new Tarifa(3));
    }

    @AfterClass
    public static void end(){
        particulares=null;
        cliente1=null;

    }

    @Before
    public void antesDeTest(){
        particulares=new ColeccionParticulares();
    }

    @Test
    public void añadirClienteTest(){
        assertTrue(particulares.añadirCliente(cliente1));

        assertTrue(particulares.añadirCliente(cliente2));
    }

    @Test
    public void existeClienteTest(){
        particulares.añadirCliente(cliente1);
        particulares.añadirCliente(cliente2);
        assertTrue(particulares.existeCliente("73402320M"));
        assertTrue(!particulares.existeCliente("0000"));
        assertTrue(particulares.existeCliente("53649080T"));
    }

    @Test
    public void getDatosClienteTest(){
        particulares.añadirCliente(cliente1);
        particulares.añadirCliente(cliente2);
        assertEquals(particulares.getDatosCliente("73402320M"),cliente1);
        assertNotEquals(particulares.getDatosCliente("73402320M"),cliente2);
        assertEquals(particulares.getDatosCliente("53649080T"),cliente2);

    }

    @Test
    public void cambiarTarifaTest(){
        int n=7;
        particulares.añadirCliente(cliente1);
        particulares.añadirCliente(cliente2);
        particulares.cambiarTarifa("73402320M",n);
        particulares.cambiarTarifa("53649080T",n+3);

        assertThat(particulares.getDatosCliente("53649080T").getTarifa().getPrecioMinuto(),is(n+3));
        assertThat(particulares.getDatosCliente("73402320M").getTarifa().getPrecioMinuto(),is(n));
    }

    @Test
    public void getListadoClientesTest(){
        particulares.añadirCliente(cliente1);
        particulares.añadirCliente(cliente2);
        int i=0;
        List<Cliente> l = new ArrayList<>();
        l.add(cliente1);
        l.add(cliente2);
        for (Cliente particular : particulares.getListadoClientes()){
            assertEquals(particular,l.get(i++));
        }
    }

    @Test
    public void clientesEntreDosFechasTest(){
        particulares.añadirCliente(cliente1);
        particulares.añadirCliente(cliente2);
        assertTrue(Utiles.entreDosFechas(particulares.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,3,1,0,0)).contains(cliente1));
        assertTrue(!Utiles.entreDosFechas(particulares.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,3,1,0,0)).contains(cliente2));

    }


}

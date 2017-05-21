package modelo.colecciones;

import modelo.Utiles;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.FactoriaCliente;
import modelo.factorias.FactoriaClientes;
import modelo.factorias.FactoriaTarifa;
import modelo.factorias.FactoriaTarifas;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vista.VistaClientes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Created by user on 28/02/17.
 */
public class ColeccionClientesTest {

    private static FactoriaCliente fabricaClientes;
    private static FactoriaTarifa fabricaTarifas;
    private static ColeccionClientes clientes;
    private static Cliente cliente1, cliente2;

    @BeforeClass
    public static void init(){
        fabricaClientes=new FactoriaClientes();
        fabricaTarifas=new FactoriaTarifas();
        cliente1=fabricaClientes.crearClienteParticular("Miguel","Matey Sanz","73402320M",new Direccion(12600,"Castellon","La Vall d'Uixó"),"al341802@uji.es",fabricaTarifas.getTarifaBasica());
        cliente2=fabricaClientes.crearClienteParticular("Sergio","Jimenez Chovares","53649080T", new Direccion(12567,"Castellon", "Castellon"),"al341933@uji.es",fabricaTarifas.getTarifaBasica());
    }

    @AfterClass
    public static void end(){
        clientes =null;
        cliente1=null;

    }

    @Before
    public void antesDeTest(){
        clientes =new ColeccionClientes();
    }

    @Test
    public void añadirClienteTest(){
        assertTrue(clientes.anyadirCliente(cliente1));

        assertTrue(clientes.anyadirCliente(cliente2));
    }

    @Test
    public void existeClienteTest(){
        clientes.anyadirCliente(cliente1);
        clientes.anyadirCliente(cliente2);
        assertTrue(clientes.existeCliente("73402320M"));
        assertTrue(!clientes.existeCliente("0000"));
        assertTrue(clientes.existeCliente("53649080T"));
    }

    @Test
    public void getDatosClienteTest(){
        clientes.anyadirCliente(cliente1);
        clientes.anyadirCliente(cliente2);
        assertEquals(clientes.getDatosCliente("73402320M"),cliente1);
        assertNotEquals(clientes.getDatosCliente("73402320M"),cliente2);
        assertEquals(clientes.getDatosCliente("53649080T"),cliente2);

    }

    @Test
    public void getListadoClientesTest(){
        clientes.anyadirCliente(cliente1);
        clientes.anyadirCliente(cliente2);
        int i=0;
        List<Cliente> l = new ArrayList<>();
        l.add(cliente1);
        l.add(cliente2);
        for (Cliente particular : clientes.getListadoClientes()){
            assertEquals(particular,l.get(i++));
        }
    }

    @Test
    public void clientesEntreDosFechasTest(){ //Al quitar LocalDateTime del constructor no podemos especificar fecha.
        /*
        clientes.anyadirCliente(cliente1);
        clientes.anyadirCliente(cliente2);
        assertTrue(Utiles.entreDosFechas(clientes.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,3,1,0,0)).contains(cliente1));
        assertTrue(!Utiles.entreDosFechas(clientes.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,3,1,0,0)).contains(cliente2));
        */
    }


}

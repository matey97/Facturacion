package facturacion.colecciones;

import facturacion.Utiles;
import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.factorias.FactoriaCliente;
import facturacion.factorias.FactoriaClientes;
import facturacion.factorias.FactoriaTarifa;
import facturacion.factorias.FactoriaTarifas;
import facturacion.tarifa.TarifaBasica;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by user on 28/02/17.
 */
public class ColeccionEmpresasTest { //Test de ColeccionEmpresas

    private static FactoriaCliente fabricaEmpresas;
    private static FactoriaTarifa fabricaTarifas;
    private static ColeccionEmpresas empresas;
    private static Cliente empresa1, empresa2;

    @BeforeClass
    public static void init(){

        fabricaEmpresas=new FactoriaClientes();
        fabricaTarifas=new FactoriaTarifas();
        empresa1 =fabricaEmpresas.crearClienteEmpresa("Copinsa","120",new Direccion(12600,"Castellon","La Vall d'Uixó"),"copinsa@yahoo.es", LocalDateTime.of(2016,1,2,0,0),fabricaTarifas.getTarifaBasica());
        empresa2 =fabricaEmpresas.crearClienteEmpresa("Mariscos Recio","130", new Direccion(12567,"Castellon", "Castellon"),"recio@gmail.es",LocalDateTime.of(2017,4,1,0,0),fabricaTarifas.getTarifaBasica());
    }

    @AfterClass
    public static void end(){
        empresas=null;
        empresa1 =null;
        empresa2=null;
    }

    @Before
    public void antesDeTest(){
        empresas=new ColeccionEmpresas();
    }

    @Test
    public void añadirClienteTest(){

        assertTrue(empresas.anyadirCliente(empresa1));

        assertTrue(empresas.anyadirCliente(empresa2));
    }

    @Test
    public void existeClienteTest(){
        empresas.anyadirCliente(empresa1);
        empresas.anyadirCliente(empresa2);
        assertTrue(empresas.existeCliente("120"));
        assertTrue(!empresas.existeCliente("0000"));
        assertTrue(empresas.existeCliente("130"));
    }

    @Test
    public void getDatosClienteTest(){
        empresas.anyadirCliente(empresa1);
        empresas.anyadirCliente(empresa2);
        assertEquals(empresas.getDatosCliente("120"), empresa1);
        assertNotEquals(empresas.getDatosCliente("120"), empresa2);
        assertEquals(empresas.getDatosCliente("130"), empresa2);

    }

    @Test
    public void getListadoClientesTest(){
        empresas.anyadirCliente(empresa1);
        empresas.anyadirCliente(empresa2);
        int i=0;
        List<Cliente> l = new ArrayList<>();
        l.add(empresa2);
        l.add(empresa1);
        for (Cliente empresa : empresas.getListadoClientes()){
            assertEquals(empresa,l.get(i++));
        }
    }

    @Test
    public void empresasEntreDosFechas(){
        empresas.anyadirCliente(empresa1);
        empresas.anyadirCliente(empresa2);
        assertTrue(Utiles.entreDosFechas(empresas.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,5,1,0,0)).contains(empresa2));
        assertTrue(!Utiles.entreDosFechas(empresas.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,5,1,0,0)).contains(empresa1));
        assertTrue(Utiles.entreDosFechas(empresas.getListadoClientes(),LocalDateTime.of(2016,1,1,0,0),LocalDateTime.of(2016,2,1,0,0)).contains(empresa1));
    }
}



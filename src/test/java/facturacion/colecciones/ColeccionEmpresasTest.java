package facturacion.colecciones;

import facturacion.excepciones.PrecioTarifaNoValido;
import facturacion.Utiles;
import facturacion.cliente.Cliente;
import facturacion.cliente.Direccion;
import facturacion.cliente.Empresa;
import facturacion.tarifa.Tarifa;
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

    private static ColeccionEmpresas empresas;
    private static Cliente empresa1, empresa2;

    @BeforeClass
    public static void init() throws PrecioTarifaNoValido{

        empresa1 =new Empresa("Copinsa","120",new Direccion(12600,"Castellon","La Vall d'Uixó"),"copinsa@yahoo.es", LocalDateTime.of(2016,1,2,0,0),new Tarifa(5));
        empresa2 =new Empresa("Mariscos Recio","130", new Direccion(12567,"Castellon", "Castellon"),"recio@gmail.es",LocalDateTime.of(2017,4,1,0,0),new Tarifa(3));
    }

    @AfterClass
    public static void end(){
        empresas=null;
        empresa1 =null;

    }

    @Before
    public void antesDeTest(){
        empresas=new ColeccionEmpresas();
    }

    @Test
    public void añadirClienteTest(){

        assertTrue(empresas.añadirCliente(empresa1));

        assertTrue(empresas.añadirCliente(empresa2));
    }

    @Test
    public void existeClienteTest(){
        empresas.añadirCliente(empresa1);
        empresas.añadirCliente(empresa2);
        assertTrue(empresas.existeCliente("120"));
        assertTrue(!empresas.existeCliente("0000"));
        assertTrue(empresas.existeCliente("130"));
    }

    @Test
    public void getDatosClienteTest(){
        empresas.añadirCliente(empresa1);
        empresas.añadirCliente(empresa2);
        assertEquals(empresas.getDatosCliente("120"), empresa1);
        assertNotEquals(empresas.getDatosCliente("120"), empresa2);
        assertEquals(empresas.getDatosCliente("130"), empresa2);

    }

    @Test
    public void cambiarTarifaTest(){
        int n=3;
        empresas.añadirCliente(empresa1);
        empresas.añadirCliente(empresa2);
        empresas.cambiarTarifa("120",n);
        empresas.cambiarTarifa("130",n+3);

        assertThat(empresas.getDatosCliente("130").getTarifa().getPrecioMinuto(),is(n+3));
        assertThat(empresas.getDatosCliente("120").getTarifa().getPrecioMinuto(),is(n));
    }

    @Test
    public void getListadoClientesTest(){
        empresas.añadirCliente(empresa1);
        empresas.añadirCliente(empresa2);
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
        empresas.añadirCliente(empresa1);
        empresas.añadirCliente(empresa2);
        assertTrue(Utiles.entreDosFechas(empresas.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,5,1,0,0)).contains(empresa2));
        assertTrue(!Utiles.entreDosFechas(empresas.getListadoClientes(),LocalDateTime.of(2017,1,1,0,0),LocalDateTime.of(2017,5,1,0,0)).contains(empresa1));
        assertTrue(Utiles.entreDosFechas(empresas.getListadoClientes(),LocalDateTime.of(2016,1,1,0,0),LocalDateTime.of(2016,2,1,0,0)).contains(empresa1));
    }
}



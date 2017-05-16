package controlador;

//import modelo.ModeloClienteParaVista;
import modelo.ModeloParaControladorCliente;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.FactoriaClientes;
import modelo.tarifa.Tarifa;
import vista.VistaParaControladorClientes;

import java.time.LocalDateTime;
//import vista.VistaCliente;

/**
 * Created by sergiojimenez on 25/4/17.
 */
public class ControladorCliente implements ControladorParaModeloCliente {

    private ModeloParaControladorCliente modelo;
    private VistaParaControladorClientes vista;


    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion ;
    private int codpos;
    private String provincia;
    private String poblacion;
    private String email;
    private LocalDateTime fecha;
    private Tarifa tarifa;

    FactoriaClientes fabricacliente = new FactoriaClientes();

    public void anyadiendoCliente() {

        if (vista.esParticular()) {
            recuperarDatos ();
            String apellidos = vista.getApellido();
            Cliente particular = fabricacliente.crearClienteParticular(nombre,apellidos,NIF,direccion,email,tarifa);//crear cliente
            modelo.anyadirCliente(particular);//mandar cliente a modeloparticular
        } else if (vista.esEmpresa()) {
            recuperarDatos ();
            Cliente empresa = fabricacliente.crearClienteEmpresa(nombre,NIF,direccion,email,tarifa);//crear cliente
            modelo.anyadirCliente(empresa);

        }
    }

    private void recuperarDatos() {

        nombre = vista.getNombre();
        NIF = vista.getNIF();
        poblacion = vista.getPoblacion();
        codpos = Integer.parseInt(vista.getCodPos());
        provincia = vista.getProv();
        direccion = new Direccion(codpos, provincia, poblacion);// getcodpos getpoblacion getprov

        String email = vista.getEmail();
       //setear  Tarifa tarifa = vista.getTarifa();

    }


    public void borrandoCliente(){
        if (vista.esParticular()) {
            String nif = vista.getNIF();
            modelo.borrarCliente(nif);
        } else if (vista.esEmpresa()) {
            String nif = vista.getNIF();
            modelo.borrarCliente(nif);
        }

    }


}

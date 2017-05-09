package controlador;

//import modelo.ModeloClienteParaVista;
import modelo.ModeloParaControlador;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.FactoriaCliente;
import modelo.tarifa.Tarifa;
import vista.VistaParaControladorClientes;

import java.time.LocalDateTime;
//import vista.VistaCliente;

/**
 * Created by sergiojimenez on 25/4/17.
 */
public class ControladorCliente implements ControladorParaModelo, ControladorParaVista {

    private ModeloParaControlador modelo;
    private VistaParaControladorClientes vista;

    private ControladorParaModelo

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

    FactoriaCliente fabricacliente = new FactoriaCliente();

    public void añadiendoCliente() {

        if (vista.esParticular()) {
            String apellidos = vista.getApellido();
            recuperarDatos ();
            Cliente particular = fabricacliente.crearClienteParticular(nombre,apellidos,NIF,direccion,email,tarifa);//crear cliente
            modelo.anyadirCliente(particular);//mandar cliente a modeloparticular
        } else if (vista.esEmpresa()) {
            recuperarDatos ();
            Cliente empresa = fabricacliente.crearClienteEmpresa(nombre,NIF,direccion,email,tarifa);//crear cliente
            modelo.anyadirCliente(empresa);

        }
    }

    public void recuperarDatos() {

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
            String nif = vista.getnif();
            modelo.borrarCliente(nif);
        } else if (vista.esEmpresa()) {
            String nif = vista.getnif();
            modelo.borrarCliente(nif);

        }

    }




  /*  private ModeloClienteParaVista modeloCliente;

    public void setModeloCliente(ModeloClienteParaVista modeloCliente) {
        this.modeloCliente = modeloCliente;
    }

    @Override
    public void nuevoClienteAnyadido() {
        modeloCliente.getListadoClientes();
    }

    @Override
    public void clienteBorrado() {
        modeloCliente.getListadoClientes();
    }

    public void obtenDatosCliente(){
        modeloCliente.getDatosCliente("123");
    }

    public void obtenListadoClientes(){
        modeloCliente.getListadoClientes();
    }

    */


    /*

     public void añadiendofactura();*/

}

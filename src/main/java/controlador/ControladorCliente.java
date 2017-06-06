package controlador;

import modelo.ModeloParaControladorCliente;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.FactoriaClientes;
import modelo.factorias.FactoriaTarifa;
import modelo.factorias.FactoriaTarifas;
import modelo.factorias.TipoPromocion;
import modelo.tarifa.Tarifa;
import vista.VistaParaControladorClientes;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 25/4/17.
 */
public class ControladorCliente implements ControladorParaVistaCliente, Serializable {

    private ModeloParaControladorCliente modelo;
    private VistaParaControladorClientes vista;

    public ControladorCliente(){
        super();
    }

    public void setVista(VistaParaControladorClientes vista) {
        this.vista = vista;
    }

    public void setModelo(ModeloParaControladorCliente modelo) {
        this.modelo = modelo;
    }

    private String nombre;
    private String apellidos;
    private String NIF;
    private Direccion direccion ;
    private int codpos;
    private String provincia;
    private String poblacion;
    private String email;

    FactoriaClientes fabricacliente = new FactoriaClientes();

    @Override
    public void anyadiendoCliente() {

        if (vista.esParticular()) {
            recuperarDatos ();
            apellidos = vista.getApellido();
            Cliente particular = fabricacliente.crearClienteParticular(nombre,apellidos,NIF,direccion,email);//crear cliente
            modelo.anyadirCliente(particular);//mandar cliente a modeloparticular
        } else if (vista.esEmpresa()) {
            recuperarDatos ();
            Cliente empresa = fabricacliente.crearClienteEmpresa(nombre,NIF,direccion,email);//crear cliente
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
        email = vista.getEmail();
       //setear  Tarifa tarifa = vista.getTarifa();

    }

    @Override
    public void borrandoCliente(){
        //generar if existe cliente
            String nif = vista.getNIFBorrar();
            modelo.borrarCliente(nif);
        //devolver a la vista para que muestre no existe cliente???
    }

    @Override
    public void setTarifaCliente() {
        if (vista.tarifaTardes() && vista.tarifaDomingos()){
            modelo.cambiarTarifa(vista.getNIFTarifa(), TipoPromocion.TARDES);
            modelo.cambiarTarifa(vista.getNIFTarifa(), TipoPromocion.DOMINGOS);
        }else if(vista.tarifaTardes()){
            modelo.cambiarTarifa(vista.getNIFTarifa(), TipoPromocion.TARDES);
        }else if(vista.tarifaDomingos()){
            modelo.cambiarTarifa(vista.getNIFTarifa(), TipoPromocion.DOMINGOS);
        }
    }


}

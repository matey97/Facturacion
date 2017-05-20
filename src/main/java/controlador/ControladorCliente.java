package controlador;

//import modelo.ModeloClienteParaVista;
import modelo.ModeloParaControladorCliente;
import modelo.cliente.Cliente;
import modelo.cliente.Direccion;
import modelo.factorias.FactoriaClientes;
import modelo.factorias.FactoriaTarifa;
import modelo.factorias.FactoriaTarifas;
import modelo.tarifa.PromocionDomingos;
import modelo.tarifa.PromocionTardes;
import modelo.tarifa.Tarifa;
import modelo.tarifa.TarifaBasica;
import vista.VistaParaControladorClientes;

import java.time.LocalDateTime;
//import vista.VistaCliente;

/**
 * Created by sergiojimenez on 25/4/17.
 */
public class ControladorCliente implements ControladorParaModeloCliente {

    private ModeloParaControladorCliente modelo;
    private VistaParaControladorClientes vista;

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
    private LocalDateTime fecha;
    private Tarifa tarifa;

    FactoriaClientes fabricacliente = new FactoriaClientes();
    FactoriaTarifa fabricaTarifa=new FactoriaTarifas();

    public void anyadiendoCliente() {

        if (vista.esParticular()) {
            recuperarDatos ();
            apellidos = vista.getApellido();
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
        tarifa=fabricaTarifa.getTarifaBasica();
        email = vista.getEmail();
       //setear  Tarifa tarifa = vista.getTarifa();

    }


    public void borrandoCliente(){
        //generar if existe cliente
            String nif = vista.getNIFBorrar();
            modelo.borrarCliente(nif);
        //devolver a la vista para que muestre no existe cliente???
    }
//_____________________________
    @Override
    public void setTarifaCliente() {

    }

    public void setTarifa(){
        String dni =vista.getNIFTarifa();
        Cliente cli = modelo.getDatosCliente(dni);
        if (modelo.existeCliente(dni)) {
            if (vista.tarifaTardes()) {
                cli.setTarifa(new PromocionTardes(tarifa,0));
            }
            if (vista.tarifaDomingos()){
                cli.setTarifa(new PromocionDomingos(tarifa));

            }
        }


        //boolean tarifaTardes()
        //boolean tarifaDomingos()
    }

}

package controlador;

import modelo.ModeloParaControladorCliente;
import modelo.ModeloParaControladorLlamada;
import modelo.ModeloParacontroladorFactura;
import modelo.Utiles;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.PeriodoFacturacion;
import vista.VistaFacturas;
import vista.VistaParaControladorClientes;
import vista.VistaParaControladorFacturas;
import vista.VistaParaControladorLlamada;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public class ControladorParaFacturas implements ControladorParaModeloFacturas  {
    //private VistaFacturas vista;
    private ModeloParacontroladorFactura modelo;
    private VistaParaControladorFacturas vista;

    public void setModelo(ModeloParacontroladorFactura modelo) {
        this.modelo = modelo;
    }

    public void setVista(VistaParaControladorFacturas vista) {
        this.vista = vista;
    }

    private int anyoini;
    private int anyofin;
    private int diaini;
    private int diaFin;
    private int mesIni;
    private int mesFini;



    public void recuperarfecha(){

        anyofin = Integer.parseInt(vista.getAnyoFin());
        anyoini =Integer.parseInt( vista.getAnyoIni());

        mesIni = Integer.parseInt(vista.getMesIni());
        mesFini =Integer.parseInt( vista.getMesFin());

        diaini = Integer.parseInt(vista.getDiaIni());
        diaFin = Integer.parseInt(vista.getDiaFin());


    }
    public void emitiendoFactura() throws FechaInicialMayorQueFinal {

        recuperarfecha();
        String dni = vista.getDNI();
        modelo.emitirFactura(modelo.getDatoscliente(dni),modelo.listarLlamadas(dni),new PeriodoFacturacion(
        LocalDateTime.of(anyoini,mesIni,diaini,00,01), LocalDateTime.of(anyofin,mesFini,diaFin,00,01)));



    }
    public void mostrarDatosFactura(){
        int codigo =Integer.parseInt(vista.getCodigo());
        modelo.recuperarDatosFactura(codigo);

    }
    public void mostrarFaturasCliente(){
        modelo.recuperarFacturasCliente(vista.getDNI());


    }
    public void mostrarFacturasentrefecha(){
        ;
        Utiles.entreDosFechas(modelo.recuperarFacturasCliente(vista.getDNI()),LocalDateTime.of(anyoini,mesIni,diaini,00,01), LocalDateTime.of(anyofin,mesFini,diaFin,00,01));




    }

}

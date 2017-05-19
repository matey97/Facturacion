package controlador;

import modelo.ModeloParaControladorCliente;
import modelo.ModeloParaControladorLlamada;
import modelo.ModeloParacontroladorFactura;
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


    public void emitiendoFactura() throws FechaInicialMayorQueFinal {

        int anyofin = Integer.parseInt(vista.getAnyoFin());
        int anyoini =Integer.parseInt( vista.getAnyoIni());

        int diaini = Integer.parseInt(vista.getDiaIni());
        int diaFin = Integer.parseInt(vista.getDiaFin());
        String dni = vista.getDNI();
        int mesIni = Integer.parseInt(vista.getMesIni());
        int mesFini =Integer.parseInt( vista.getMesFin());

        modelo.emitirFactura(modelo.getDatoscliente(dni),modelo.listarLlamadas(dni),new PeriodoFacturacion(
        LocalDateTime.of(anyoini,mesIni,diaini,01,01), LocalDateTime.of(anyofin,mesFini,diaFin,01,01)));



    }
    public void mostrarDatosFactura(){
        int codigo =Integer.parseInt(vista.getCodigo());
        modelo.recuperarDatosFactura(codigo);

    }
    public void mostrarFaturasCliente(){
        modelo.recuperarFacturasCliente(vista.getDNI());


    }

}

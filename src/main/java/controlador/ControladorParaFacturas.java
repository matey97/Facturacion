package controlador;

import modelo.*;
import modelo.colecciones.ColeccionClientes;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.PeriodoFacturacion;
import vista.VistaParaControladorFacturas;

import java.time.LocalDateTime;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public class ControladorParaFacturas implements ControladorParaVistaFacturas {
    //private VistaFacturas vista;
    private ModeloParacontroladorFactura modeloFacturas;
    private ModeloParaControladorLlamada modeloLlamadas;
    private ModeloParaControladorCliente modeloClientes;
    private VistaParaControladorFacturas vista;

    public void setModeloFacturas(ModeloParacontroladorFactura modelo) {
        this.modeloFacturas = modelo;
    }

    public void setModeloLlamadas(ModeloParaControladorLlamada modeloLlamadas) {
        this.modeloLlamadas = modeloLlamadas;
    }

    public void setModeloClientes(ModeloParaControladorCliente modeloClientes) {
        modeloClientes = modeloClientes;
    }

    public void setVista(VistaParaControladorFacturas vista) {
        this.vista = vista;
    }

    private ColeccionClientes Clientes;

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
        LocalDateTime ini = LocalDateTime.of(anyoini,mesIni,diaini,00,01);
        LocalDateTime fin = LocalDateTime.of(anyofin,mesFini,diaFin,00,01);

        if (fin.isBefore(ini)){
            throw new FechaInicialMayorQueFinal("Fecha erronea");
        }else {
            recuperarfecha();
            String dni = vista.getDNI();

            modeloFacturas.emitirFactura(modeloClientes.getDatosCliente(dni), modeloLlamadas.listarLlamadas(dni), new PeriodoFacturacion(ini, fin));

        }

    }
  /*  public void mostrarDatosFactura(){
        int codigo =Integer.parseInt(vista.getCodigo());
        modelo.recuperarDatosFactura(codigo);

    }
    public void mostrarFaturasCliente(){
        modelo.recuperarFacturasCliente(vista.getDNI());



    }
    public void mostrarFacturasentrefecha(){

        Utiles.entreDosFechas(modelo.recuperarFacturasCliente(vista.getDNI()),LocalDateTime.of(anyoini,mesIni,diaini,00,01), LocalDateTime.of(anyofin,mesFini,diaFin,00,01));


    }
*/
}

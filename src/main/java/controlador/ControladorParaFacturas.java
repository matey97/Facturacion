package controlador;

import modelo.ModeloParaControladorCliente;
import modelo.ModeloParaControladorLlamada;
import modelo.ModeloParacontroladorFactura;
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

    public void emitiendoFactura(){

        String anyofin = vista.getAnyoFin();
        String anyoini = vista.getAnyoIni();
        String codigo = vista.getCodigo();
        String diaini = vista.getDiaIni();
        String diaFin = vista.getDiaFin();
        String dni = vista.getDNI();
        String mesIni = vista.getMesIni();
        String mesFini = vista.getMesFin();
        public Factura( Tarifa tarifa, LocalDateTime fechaDeEmision, PeriodoFacturacion periodofact, int importe) {


        modelo.emitirFactura(vista.getDNI(),vista.);

    }
}

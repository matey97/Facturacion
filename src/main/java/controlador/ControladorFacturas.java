package controlador;

import modelo.*;
import modelo.colecciones.ColeccionClientes;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.excepciones.NoExisteCliente;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;
import vista.VistaParaControladorFacturas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public class ControladorFacturas implements ControladorParaVistaFacturas, Serializable {

    private ModeloParacontroladorFactura modeloFacturas;
    private ModeloLlamadasParaControladorFactura modeloLlamadas;
    private ModeloClienteParaControladorFactura modeloClientes;
    private VistaParaControladorFacturas vista;

    public void setModeloFacturas(ModeloParacontroladorFactura modeloFacturas) {
        this.modeloFacturas = modeloFacturas;
    }

    public void setModeloLlamadas(ModeloLlamadasParaControladorFactura modeloLlamadas) {
        this.modeloLlamadas = modeloLlamadas;
    }

    public void setModeloClientes(ModeloClienteParaControladorFactura modeloClientes) {
        this.modeloClientes = modeloClientes;
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

    @Override
    public void emitiendoFactura() throws FechaInicialMayorQueFinal {
        recuperarfecha();
        LocalDateTime ini = LocalDateTime.of(anyoini,mesIni,diaini,0,0);
        LocalDateTime fin = LocalDateTime.of(anyofin,mesFini,diaFin,0,0);

        if (fin.isBefore(ini)){
            throw new FechaInicialMayorQueFinal("Fecha erronea");
        }else {
            String dni = vista.getDNI();

            try {
                Collection<Llamada> llamadas= modeloLlamadas.listarLlamadas(dni);
                modeloFacturas.emitirFactura(modeloClientes.getDatosCliente(dni), llamadas, new PeriodoFacturacion(ini, fin));
            }catch (Exception m) {
                vista.noExisteCliente();
            }
        }
    }

}



package controlador;

import modelo.*;
import modelo.colecciones.ColeccionClientes;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.excepciones.FechaInicialMayorQueFinal;
import modelo.factura.Llamada;
import modelo.factura.PeriodoFacturacion;
import vista.VistaParaControladorFacturas;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by sergiojimenez on 16/5/17.
 */
public class ControladoFacturas implements ControladorParaVistaFacturas {

    private ModeloParacontroladorFactura modeloFacturas;
    private ModeloParaControladorLlamada modeloLlamadas;
    private ModeloParaControladorCliente modeloClientes;
    private VistaParaControladorFacturas vista;

    public void setModeloFacturas(ModeloParacontroladorFactura modeloFacturas) {
        this.modeloFacturas = modeloFacturas;
    }

    public void setModeloLlamadas(ModeloParaControladorLlamada modeloLlamadas) {
        this.modeloLlamadas = modeloLlamadas;
    }

    public void setModeloClientes(ModeloParaControladorCliente modeloClientes) {
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
    public void emitiendoFactura() throws FechaInicialMayorQueFinal, ExcepcionClienteSinLlamadas {
        LocalDateTime ini = LocalDateTime.of(anyoini,mesIni,diaini,00,01);
        LocalDateTime fin = LocalDateTime.of(anyofin,mesFini,diaFin,00,01);

        if (fin.isBefore(ini)){
            throw new FechaInicialMayorQueFinal("Fecha erronea");
        }else {
            recuperarfecha();
            String dni = vista.getDNI();
            Collection<Llamada> llamadas= modeloLlamadas.listarLlamadas(dni);
            modeloFacturas.emitirFactura(modeloClientes.getDatosCliente(dni), llamadas, new PeriodoFacturacion(ini, fin));
            }
        }

    }

}

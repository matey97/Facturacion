package modelo.colecciones;

import controlador.ModeloLlamadasParaControladorFactura;
import modelo.ModeloLlamadaParaVista;
import modelo.ModeloParaControladorLlamada;
import modelo.excepciones.ExcepcionClienteSinLlamadas;
import modelo.factura.Llamada;
import vista.VistaParaModeloLlamada;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by user on 27/02/17.
 */
public class ColeccionLlamadas implements  Serializable, ModeloLlamadaParaVista, ModeloParaControladorLlamada, ModeloLlamadasParaControladorFactura {

    private HashMap<String,LinkedList<Llamada>> llamadas;
    private VistaParaModeloLlamada vista;



    public ColeccionLlamadas(){
        llamadas=new HashMap<>();
    }

    public void setVista(VistaParaModeloLlamada vista) {
        this.vista = vista;
    }

    public void darDeAlta(String nif, Llamada llamada) throws  ExcepcionClienteSinLlamadas{
        if (!llamadas.containsKey(nif)) {
            llamadas.put(nif, new LinkedList<>());
        }
        llamadas.get(nif).add(llamada);
        vista.llamadaDadaDeAlta();
    }

    public Collection<Llamada> listarLlamadas(String nif) throws ExcepcionClienteSinLlamadas{
        Collection<Llamada> llamadasNif =llamadas.get(nif);
        if (llamadasNif!=null){
            return llamadasNif;
        }else{
            throw new ExcepcionClienteSinLlamadas("no hay llamadas");
        }
    }
}

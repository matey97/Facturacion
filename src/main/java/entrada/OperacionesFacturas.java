package entrada;

import facturacion.factura.Factura;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

/**
 * Created by sergiojimenez on 28/2/17.
 */
public class OperacionesFacturas {

    public Factura emisionFactura (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nifcliente:");
                    System.out.println("Introduce 2 para --> Obtener datos de factura a partir de su codigo");
                    System.out.println("Introduce 3 para --> Obtener facturas de un cliente");
                    return null; //Pongo el return por el error al compilar
    }
    public void mostrarDatosFactura(){// devuelve los atributos de la factura por pantallausando toString

    }
/*    public _____ listadoFacturasCliente(){ Comento para que no haya error al compilar

    }*/
}

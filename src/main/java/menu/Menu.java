package menu;

import entrada.OperacionesCliente;
import facturacion.colecciones.ColeccionClientes;
import facturacion.colecciones.ColeccionEmpresas;
import facturacion.colecciones.ColeccionParticulares;

import java.util.Scanner;
/**
 * Created by al341802 on 21/02/17.
 */
public class Menu {

    public static void main(String[] args) {
        OperacionesCliente opCliente=new OperacionesCliente();
        ColeccionClientes particulares = new ColeccionParticulares();
        ColeccionClientes empresas= new ColeccionEmpresas();
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("¿Que tipo de gestión quieres realizar?");
            System.out.println("Introduce 0 para --> Salir");
            System.out.println("Introduce 1 para --> Gestión clientes");
            System.out.println("Introduce 2 para --> Gestión llamadas");
            System.out.println("Introduce 3 para --> Gestión facturas");
            n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Introduce 1 para --> Dar de alta un cliente");
                    System.out.println("Introduce 2 para --> Borrar un cliente");
                    System.out.println("Introduce 3 para --> Cambiar tarifa de cliente");
                    System.out.println("Introduce 4 para --> Obtener datos de cliente a partir de DNI");
                    System.out.println("Introduce 5 para --> Listado de clientes");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            int m;
                            System.out.println("Introduce 1 si quieres dar de alta a un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    opCliente.nuevoCliente(particulares, m);
                                    break;
                                case 2:
                                    opCliente.nuevoCliente(empresas, m);
                                    break;
                            }
                        case 2:
                            System.out.println("Introduce 1 si quieres borrar a un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    opCliente.borrarCliente(particulares);
                                    break;
                                case 2:
                                    opCliente.borrarCliente(empresas);
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("Introduce 1 si quieres cambiar la tarifa a un particular, o 2 si a una empresa");
                            m = sc.nextInt();
                            switch (m) {
                                case 1:
                                    opCliente.nuevoCliente(particulares, m);
                                    break;
                                case 2:
                                    opCliente.nuevoCliente(empresas, m);
                                    break;
                            }
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Introduce 1 para --> Dar de alta una llamada");
                    System.out.println("Introduce 2 para --> Listado de llamadas de un cliente");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Introduce 1 para --> Emitir factura para un cliente");
                    System.out.println("Introduce 2 para --> Obtener datos de factura a partir de su codigo");
                    System.out.println("Introduce 3 para --> Obtener facturas de un cliente");
                    n = sc.nextInt();
                    switch (n) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;


            }
        }while(n!=0);

    }
}

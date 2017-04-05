package enums;

/**
 * Created by sergiojimenez on 5/4/17.
 */
public enum MenuEnumClientes {

    DAR_DE_ALTA_UN_CLIENTE(" Dar de alta un cliente"),
    BORRAR_UN_CLIENTE("Borrar un cliente"),
    CAMBIAR_TARIFA_CLIENTE("Cambiar tarifa de cliente"),
    OBTENER_DATOS_CLIENTE("Obtener datos de cliente a partir de DNI"),
    LISTADO_CLIENTES("Listado de clientes"),
    LISTADO_CLIENTES_DADOS_DEALTA_ENTRE_DOS_FECHAS("Listado de clientes dados de alta entre dos fechas");


    private String descripcion;

    private MenuEnumClientes(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public static MenuEnumClientes getOpcion(int posicion) {

        return values()[posicion];
    }



        public static String mostrarMenu () {
        StringBuilder sb = new StringBuilder();

        for (MenuEnumClientes opcion : MenuEnumClientes.values()) {

            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();

    }


    }


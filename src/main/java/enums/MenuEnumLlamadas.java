package enums;

/**
 * Created by sergiojimenez on 5/4/17.
 */
public enum MenuEnumLlamadas {

    ALTA_LLAMADA(" Dar de alta una llamada"),
    LISTADO_LLAMADAS_CLIENTE("Listado de llamadas de un cliente"),
    LISTADO_LLAMADAS_CLIENTE_ENTRE_FECHAS("Listado de llamadas de un cliente realizadas entre dos fechas");


    private String descripcion;

    private MenuEnumLlamadas(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public static MenuEnumLlamadas getOpcion(int posicion) {

        return values()[posicion];
    }



        public static String mostrarMenu () {
        StringBuilder sb = new StringBuilder();

        for (MenuEnumLlamadas opcion : MenuEnumLlamadas.values()) {

            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();

    }


    }


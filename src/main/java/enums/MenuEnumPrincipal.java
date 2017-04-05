package enums;

/**
 * Created by sergiojimenez on 5/4/17.
 */
public enum MenuEnumPrincipal {

    SALIR("Salir"),
    GESTION_CLIENTES("Gestión clientes"),
    GESTION_LLAMADAS("Gestión llamadas"),
    GESTION_FACTURAS("Gestión facturas");


    private String descripcion;

    private MenuEnumPrincipal(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public static MenuEnumPrincipal getOpcion(int posicion) {

        return values()[posicion];
    }



        public static String mostrarMenu () {
        StringBuilder sb = new StringBuilder();

        for (MenuEnumPrincipal opcion : MenuEnumPrincipal.values()) {

            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();

    }


    }


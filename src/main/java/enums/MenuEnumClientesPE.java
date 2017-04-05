package enums;

/**
 * Created by sergiojimenez on 5/4/17.
 */
public enum MenuEnumClientesPE {

    PARTICULAR("Añadir un cliente Particular"),
    EMPRESA("Añadir una Cliente Empresa");



    private String descripcion;

    private MenuEnumClientesPE(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public static MenuEnumClientesPE getOpcion(int posicion) {

        return values()[posicion];
    }



        public static String mostrarMenu () {
        StringBuilder sb = new StringBuilder();

        for (MenuEnumClientesPE opcion : MenuEnumClientesPE.values()) {

            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();

    }


    }


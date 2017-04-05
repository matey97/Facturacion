package enums;

/**
 * Created by sergiojimenez on 5/4/17.
 */
public enum MenuEnumFacturas {

    EMITIR_FACTURA_CLIENTE("Emitir factura para un cliente"),
    OBTENER_DATOS_FACTURA_DESDE_CODIGO("Obtener datos de factura a partir de su codigo"),
    OBTENER_FACTURAS_CLIENTE(" Obtener facturas de un cliente"),
    OBTENER_FACTURAS_CLIENTE_EMITIDAS_ENTRE_DOS_FECHAS("Obtener facturas de un cliente emitidas entre dos fechas");


    private String descripcion;

    private MenuEnumFacturas(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public static MenuEnumFacturas getOpcion(int posicion) {

        return values()[posicion];
    }



        public static String mostrarMenu () {
        StringBuilder sb = new StringBuilder();

        for (MenuEnumFacturas opcion : MenuEnumFacturas.values()) {

            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.getDescripcion());
            sb.append("\n");
        }
        return sb.toString();

    }


    }


package enums;

/**
 * Created by sergiojimenez on 5/4/17.
 */

//si podemos implementar el cuerp de los metodos en esta interfaz ahorariamos
// en codigo en todas las enums

//_________________________________________________________
public interface EnumsFacturacion {
    public static String getDescripcion() {
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

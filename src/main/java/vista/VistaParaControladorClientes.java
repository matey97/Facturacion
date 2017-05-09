package vista;

/**
 * Created by User on 03/05/2017.
 */
public interface VistaParaControladorClientes {
    String getNIF();
    String getNIFBorrar();
    String getNIFTarifa();
    String getNIFDatos();
    String getNombre();
    String getApellido();
    String getCodPos();
    String getPoblacion();
    String getProv();
    String getEmail();
    boolean esParticular();
    boolean esEmpresa();
    boolean tarifaTardes();
    boolean tarifaDomingos();
}

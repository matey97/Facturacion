package vista;

import javax.swing.*;

/**
 * Created by al341802 on 2/05/17.
 */
public class InterfazGrafica {

    public InterfazGrafica() {
        super();
    }

    public void ejecuta(){
        JFrame ventana=new JFrame("Facturación");
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}

package menu;

import javax.swing.*;


/**
 * Created by al341802 on 21/02/17.
 */
public class Main {

    public static void main(String[] args) {

        Gestion gestion=new Gestion();

        gestion.iniciaMVC();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gestion.cargaInterfaz();
            }
        });
    }

}

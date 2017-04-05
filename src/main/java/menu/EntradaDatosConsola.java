package menu;

import enums.MenuEnumPrincipal;

/**
 * Created by sergiojimenez on 5/4/17.
 */
public class EntradaDatosConsola {
    System.out.println(MenuEnumPrincipal.getMenu());
    Scanner scanner = new Scanner(System.in);
    System.out.print("Elije una opción:");
    byte opcion = scanner.nextByte();
    OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
    switch(opcionMenu)

}

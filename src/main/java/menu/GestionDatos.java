package menu;

import modelo.colecciones.*;

import java.io.*;

/**
 * Created by sergiojimenez on 28/4/17.
 */
public class GestionDatos {
    ColeccionClientes particulares = new ColeccionParticulares();
    ColeccionClientes empresas= new ColeccionEmpresas();
    ColeccionLlamadas llamadas = new ColeccionLlamadas();
    ColeccionFacturas facturas= new ColeccionFacturas();

    public void cargarDatos(){
        try{
            FileInputStream fichParticulares = new FileInputStream("particulares.bin");
            FileInputStream fichEmpresas = new FileInputStream("empresas.bin");
            FileInputStream fichLlamadas = new FileInputStream("llamadas.bin");
            FileInputStream fichFacturas = new FileInputStream("facturas.bin");
            ObjectInputStream objParticulares = new ObjectInputStream(fichParticulares);
            ObjectInputStream objEmpresas = new ObjectInputStream(fichEmpresas);
            ObjectInputStream objLlamadas = new ObjectInputStream(fichLlamadas);
            ObjectInputStream objFacturas = new ObjectInputStream(fichFacturas);
            particulares = (ColeccionClientes) objParticulares.readObject();
            empresas = (ColeccionClientes) objEmpresas.readObject();
            llamadas = (ColeccionLlamadas) objLlamadas.readObject();
            facturas = (ColeccionFacturas) objFacturas.readObject();
            objParticulares.close();
            objEmpresas.close();
            objLlamadas.close();
            objFacturas.close();
        } catch(FileNotFoundException e){
            System.out.println("Error del fichero.");
            System.out.println(e);
        } catch(IOException e){
            System.out.println("Error en ObjectInputStream.");
            System.out.println(e);
        } catch(ClassNotFoundException e){
            System.out.println("Error al recuperar datos del fichero.");
            System.out.println(e);
        }


    }


    public void guardarDatos () {
        try {
            FileOutputStream fichParticulares = new FileOutputStream("particulares.bin");
            FileOutputStream fichEmpresas = new FileOutputStream("empresas.bin");
            FileOutputStream fichLlamadas = new FileOutputStream("llamadas.bin");
            FileOutputStream fichFacturas = new FileOutputStream("facturas.bin");
            ObjectOutputStream objParticulares = new ObjectOutputStream(fichParticulares);
            ObjectOutputStream objEmpresas = new ObjectOutputStream(fichEmpresas);
            ObjectOutputStream objLlamadas = new ObjectOutputStream(fichLlamadas);
            ObjectOutputStream objFacturas = new ObjectOutputStream(fichFacturas);
            objParticulares.writeObject(particulares);
            objEmpresas.writeObject(empresas);
            objLlamadas.writeObject(llamadas);
            objFacturas.writeObject(facturas);
            objParticulares.close();
            objEmpresas.close();
            objLlamadas.close();
            objFacturas.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al intentar abrir el fichero.");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error en ObjectOutputStream");
            System.out.println(e);
        }

    }

    public ColeccionClientes getParticulares() {
        return particulares;
    }

    public ColeccionClientes getEmpresas() {
        return empresas;
    }

    public ColeccionLlamadas getLlamadas() {
        return llamadas;
    }

    public ColeccionFacturas getFacturas() {
        return facturas;
    }


}

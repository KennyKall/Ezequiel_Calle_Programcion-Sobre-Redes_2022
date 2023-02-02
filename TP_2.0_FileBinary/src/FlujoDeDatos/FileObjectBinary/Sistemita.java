/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import static FlujoDeDatos.FileObjectBinary.Utilidades.mostrarPorPantalla;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * NO SE PUEDE SERIALIZAR UN ATRIBUTO ESTATICO
 * @author Software-Notebook
 */
public class Sistemita implements Serializable {

    private static final long serialVersionUID = -1000L;
    private BaseDeUsuario usuarios;
        
    public Sistemita() {
        usuarios = new BaseDeUsuario();
    }

    /**
     * Deserializa un archivo binario a fin de cargar datos de la ejecución anterior
     * 
     * @param archivo
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        return s;
    }

    /**
     * Arranca el sistema
     */
    public void creacion() {
        Utilidades.mostrarPorPantalla(" EL SISTEMA SE HA ARRANCADO. ");
        
        Empleado e = new Empleado( usuarios , 0, Puestos.Gerente, 0, new Date(0000, 00, 00), "empleado", "empleado", "", 0, Genero.SG, "0000-0000");
        Socio s = new Socio( usuarios , TipoMembrecia.Bronce, 0, new Date(0000,00,00), "socio", "socio", "", 0, Genero.SG, "0000-0000");

        usuarios.agregarUsuario( e );
        usuarios.agregarUsuario( s );
        
    }

    /**
     * Serializa la ejecucion del programa en un archivo binario (realiza un DAM de memoria)
     * Serializa un archivo binario (DAM de memoria)
     * 
     * @param archivo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    
    /**
     * ESTE PASARIA A SER NUETRO MAIN
     */
    public void prender() {
        // aca vamos a hacer un menu
        boolean corriendo = true;
        
        while( corriendo )
        {
            //Utilidades.mostrarMenu();
            corriendo = mostrarMenu();    
        }
        Utilidades.mostrarPorPantalla("GRACIAS POR USAR MI PROGRAMA.");
              
    }


    /**
     * Muestra el menú principal, solicita y procesa la opción elegida.
     * @return variable continuar para determinar que finalizó el programa
     */
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                mostrarPorPantalla(
                        "MENÚ PRINCIPAL\n\n"
                        + "[1] Menu de Empleados\n"
                        + "[2] Menu de Socios\n"
                        + "[3] Salir\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '1':
                    continuar = usuarios.devolverUsurio(0).mostrarMenu() ;
                    break;
                case '2':
                    continuar = usuarios.devolverUsurio(1).mostrarMenu() ;
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }     
    
}

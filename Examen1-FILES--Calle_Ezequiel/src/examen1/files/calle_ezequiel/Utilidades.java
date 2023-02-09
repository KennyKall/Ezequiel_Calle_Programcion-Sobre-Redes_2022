/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.calle_ezequiel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Utilidades {
    
    public static char menu() { //Menu del programa
        char op;
        do {
            mostrarMensaje(
                      "+----------------------------------+\n"
                    + "|          MENÚ PRINCIPAL          |\n"
                    + "+-----┬----------------------------+\n"
                    + "| [1] |     Agregar un Producto    |\n"
                    + "+-----+----------------------------+\n"
                    + "| [2] | Mostar todos los Productos |\n"
                    + "+-----+----------------------------+\n"
                    + "| [3] |       Calcular Stock       |\n"
                    + "+-----+----------------------------+\n"
                    + "| [0] |           Salir            |\n"
                    + "+-----┴----------------------------+"
            );
            op = Utilidades.obtenerOpcion();
        } while (op < '0' || op > '3');

        return op;
    }
    
    /**
     * Muestra un mensaje por la consola utilizando PrintStream
     * @param texto 
     */
    public static void mostrarMensaje(String texto){
        PrintStream ps;
        ps = new PrintStream(System.out);
        ps.println( texto );
    }
    
    /**
     * Lee un numero ingresado por la consola
     * @return numero
     */
    public static int leerNumero() {
        int n = 0;
        try {
            
            int Byte = -1;
            String texto = "";
            
            while(  (Byte = System.in.read()) != '\n'  )
            {
                texto = texto + (char)Byte;
            }
            
            n = Integer.parseInt(texto);
            
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    /**
     * Lee texto ingresado por la consola
     * @return texto
     */
    public static String leerTexto()
    {
        String texto = "";
        try {
            
            int Byte = -1;
            
            while(  (Byte = System.in.read()) != '\n'  )
            {
                texto = texto + (char)Byte;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return texto;
    }
    
    public static char obtenerOpcion(){ //Muestra por consola un mensaje para elejir una opcion y luego lee la opcion
        char dato = ' ';
        try {
            System.out.println("    ┌---------------------------┐");
            System.out.println("    | Elija una de las opciones :");
            System.out.println("    └---------------------------┘");
            dato = (char)System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dato;
    }
    
    /**
     * Valida si un dato es nulo
     * @param dato
     * @return false si es nulo y true si no lo es
     */
    public static boolean validar(Object dato)
    {
        if(dato == null)
            return false;
        else
            return true;
    }
 
    public void escribir(File f, String texto) {
        FileWriter fw = null;
        PrintWriter pw = null;

        try {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);
            
            pw.println(texto);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

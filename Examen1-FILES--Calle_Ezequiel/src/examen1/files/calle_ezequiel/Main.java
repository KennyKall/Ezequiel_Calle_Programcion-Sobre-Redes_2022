/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.calle_ezequiel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redes-17
 */

public class Main{

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        PrintStream ps;
        File datos = new File("datos.csv"); //Se crea el archivo segun lo pedido en la consigna
        
        try {
            ps = new PrintStream(new FileOutputStream("datos.csv",true));
            ps.flush(); ps.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Productos p = new Productos();

        p.iniciar(); //Inicia el programa
    }
}

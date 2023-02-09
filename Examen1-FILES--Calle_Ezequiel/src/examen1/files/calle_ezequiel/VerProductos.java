/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.calle_ezequiel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redes-17
 */
class VerProductos {
    PrintStream ps;

    public void mostrarProductos(File f){
        //Ejecuta la segunda opcion del menú luego de elegirla, en esta ejecucion
        //muestra por consola los produstos que se tienen rtegistrados en datos.csv
        Utilidades u = new Utilidades();
        u.mostrarMensaje(leer(f));
    }
    
    public String leer(File f) {
        String texto = "";
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                texto += "\n" + linea;
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VerProductos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VerProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return texto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.pkg1.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soft-04
 */
public class AlmacenarDatos {
    File datosPartida;
    PrintStream ps;
    
    public AlmacenarDatos(){
        ps = new PrintStream(System.out);
        
        datosPartida = new File ("\\\\C:\\Users\\Soft-04\\Downloads\\Examen 1\\datos_partidas.txt");
        
        
        crearFileConPrintStream(datosPartida);

 public void crearFileConPrintStream(File) {
    
    FileOutputStream fos = null;
}
    }

    

    
    








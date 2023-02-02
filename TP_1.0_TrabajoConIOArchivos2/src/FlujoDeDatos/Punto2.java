/*
 * Esta clase resuelve las consignas del punto 2 del trabajo práctico N°1
 */
package FlujoDeDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mendez Agustín 6°1
 */
public class Punto2 {
    PrintStream ps;
    
    /**
     * Este método recorre un vector de 5 posiciones y divide cada uno de ellos
     * con el número que quede de la siguiente operación (siguiente número del vector - 3),
     * almacenandolos en un archivo de texto.
     * 
     * @param v recibe un vector de 5 posiciones
     */
    public void operacionDelVector(int x, int[] v){
        BufferedWriter bw = null;
        FileWriter fw = null;
        boolean error=false;

        try {
            File archivo = new File("resultados.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            int n1 = 0;
            int n2 = 0;
            int resultado = 0;
            for(int i = x ; i < 5 ; i++){
                try {
                    n1 = v[i];
                
                    if(i==4){ //para evitar un error, el último número se divide a si mismo-3
                        n2 = v[i] - 3;
                    }else{
                        n2 = v[i+1] - 3;
                    }

                    resultado = n1/n2;
                    
                    bw.write(String.valueOf(n1) + " / " + String.valueOf(n2) + " = " + String.valueOf(resultado));
                    bw.newLine();
                    bw.flush();
                    
                }catch(ArithmeticException ex){
                    File archivoError = new File("error.txt");
                    FileOutputStream fos = new FileOutputStream(archivoError,true);
                    ps = new PrintStream( fos );
                    System.setErr( ps );       

                    Logger.getLogger(Punto2.class.getName()).log(Level.SEVERE, "Error formateado por el logger");             
                    System.err.println( "Error: " + String.valueOf(n1) + " / " + String.valueOf(n2) + " = error");
                    error=true;
                }finally{
                    if (error && (v.length < x+1)){
                        operacionDelVector(x, v);
                    }
                }
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Punto2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

                if (bw != null) {
                    bw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Punto2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

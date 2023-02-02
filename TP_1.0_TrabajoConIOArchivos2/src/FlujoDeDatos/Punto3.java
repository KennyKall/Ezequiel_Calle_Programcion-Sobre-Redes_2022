/*
 * Esta clase resuelve las consignas del punto 3 del trabajo práctico N°1

3) Leer los datos numéricos de los 2 orígenes guardados en el punto 1 y generar 2 archivos
de salida:
-Por un lado, los resultados de la división entre cada dato leído y el numero 3 en un archivo
“resultados.txt”. Con el formato en un renglón por cuenta: numero1 / numero2 = resultado

-Y por el otro lado, cada vez que la división tire un error matemático o de falta de algún
número de entrada, guardar el error correspondiente en un archivo “error.txt” ubicado en
la carpeta del proyecto.
 */
package FlujoDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mendez Agustín 6°1
 */
public class Punto3 {
    PrintStream ps;
    
    /**
     * Este método recorre un vector de 5 posiciones (primer origen) y divide cada
     * uno de ellos entre 3 almacenandolos en un archivo de texto y creando el
     * archivo "error.txt2" en caso de error.
     * @param x Utilizado por recursividad en el caso de existir un error.
     * @param v Vector a operar.
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
            int resultado = 0;
            for(int i = x ; i < 5 ; i++){
                try {
                    n1 = v[i];

                    resultado = n1/3;
                    
                    bw.write(String.valueOf(n1) + " / 3 = " + String.valueOf(resultado));
                    bw.newLine();
                    bw.flush();
                    
                }catch(ArithmeticException ex){
                    File archivoError = new File("error.txt");
                    FileOutputStream fos = new FileOutputStream(archivoError,true);
                    ps = new PrintStream( fos );
                    System.setErr( ps );       

                    Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, "Error formateado por el logger");             
                    System.err.println( "Error: " + String.valueOf(n1) + " / 3 " + " = error");
                    error=true;
                }catch(NullPointerException e){
                    File archivoError = new File("error.txt");
                    FileOutputStream fos = new FileOutputStream(archivoError,true);
                    ps = new PrintStream( fos );
                    System.setErr( ps );       

                    Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, "Error formateado por el logger");             
                    System.err.println( "Error: Verifique el ingreso de datos");
                    error=true;
                }finally{
                    if (error && (v.length < x+1)){
                        operacionDelVector(x, v);
                    }
                }
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

                if (bw != null) {
                    bw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Este método lee un archivo (segundo origen) y divide los números en su interior
     * por 3, almacenando los resultados en un archivo de texto y creando el
     * archivo "error.txt2" en caso de error.
     * @param x Utilizado por recursividad en el caso de existir un error.
     */
    public void operacionDelArchivo(int x){
        BufferedWriter bw = null;
        FileWriter fw = null;
        boolean error=false;
        
        File f = new File("texto.txt"); //números guardados en el punto 1
        ArrayList<Integer> datos = new ArrayList<Integer>();

        try {
            /*----------LECTURA-------------*/
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                datos.add(Integer.parseInt(linea));
            }

            br.close();
            fr.close();
            
            /*--------------OPERACIONES DE LOS DATOS----------------*/

            File archivo = new File("resultados.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            int n1 = 0;
            int resultado = 0;
            for(int i = x; i < datos.size(); i++){
                try {
                    n1 = datos.get(i);
                    System.out.println(n1);
                    
                    resultado = n1/3;
                    
                    bw.write(String.valueOf(n1) + " / 3 = " + String.valueOf(resultado));
                    bw.newLine();
                    bw.flush();
                    
                }catch(ArithmeticException ex){
                    File archivoError = new File("error.txt");
                    FileOutputStream fos = new FileOutputStream(archivoError,true);
                    ps = new PrintStream( fos );
                    System.setErr( ps );       

                    Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, "Error formateado por el logger");             
                    System.err.println( "Error: " + String.valueOf(n1) + " / 3 " + " = error");
                    error=true;
                }catch(NullPointerException e){
                    File archivoError = new File("error.txt");
                    FileOutputStream fos = new FileOutputStream(archivoError,true);
                    ps = new PrintStream( fos );
                    System.setErr( ps );       

                    Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, "Error formateado por el logger");             
                    System.err.println( "Error: Verifique el ingreso de datos");
                    error=true;
                }finally{
                    if (error && (datos.size() < x+1)){
                        operacionDelArchivo(i);
                    }
                }
            }
            

        } catch (IOException ex) {
            Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

                if (bw != null) {
                    bw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Punto3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

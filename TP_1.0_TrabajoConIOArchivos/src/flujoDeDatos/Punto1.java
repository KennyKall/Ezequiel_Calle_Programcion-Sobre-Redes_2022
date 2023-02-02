/*
 * Esta clase resuelve las consignas del punto 1 del trabajo práctico N°1
 */
package flujoDeDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mendez Agustín 6°1
 */
public class Punto1 {
    InputStreamReader is;
    BufferedReader br;
    PrintStream ps;
    
    /**
     * Este método realiza una lectura de datos byte a byte mediante el canal System.in.
     * 
     * @return Resultado de la lectura (integer)
     */
    public int Lectura1(){
        int dato = -1;
        
        try {
            
            int Byte = -1;
            String entrada = "";
            ps = new PrintStream( System.out );
            
            ps.println("Ingrese un número: "); 
            
            while(  (Byte = System.in.read()) != '\n'  )
            {
                entrada = entrada + (char)Byte;
            }
            
            dato = Integer.parseInt(entrada);
            
        } catch (IOException ex) {
            Logger.getLogger(Punto1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dato;
    }
    
    /**
     * Este método realiza una lectura de datos mediante un buffer de lectura.
     * 
     * @return Resultado de la lectura (integer)
     */
    public int Lectura2Buffer() {
        
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        ps = new PrintStream( System.out );
        
        int dato = -1;
        
        try {
            ps.println("Ingrese un número: ");  
            String entrada = br.readLine();
            dato = Integer.parseInt(entrada);
            
        } catch (IOException ex) {
            Logger.getLogger(Punto1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dato;
    }
    
    /**
     * Este método solicita 5 números y los almacena en un vector.
     * 
     * @return Vector de 5 posiciones
     */
    public int[] almacenadoVolatil(){
        int[] vec = new int[5];
        
        for(int i = 0 ; i < 5 ; i++){
            vec[i] = Lectura1();
        }
        
        return vec;
    }
    
    /**
     * Este método solicita 5 números utilizando un buffer de lectura y los almacena en un vector.
     * 
     * @return Vector de 5 posiciones
     */
    public int[] almacenadoVolatilConBuffer(){
        int[] vec = new int[5];
        
        for(int i = 0 ; i < 5 ; i++){
            vec[i] = Lectura2Buffer();
        }
        
        return vec;
    }
    
    /**
     * Este método solicita 5 números y los almacena en un archivo de texto mediante un buffer de escritura.
     * @param modo Se ingresará 1 si la lectura se realiza SIN buffer, se ingresará otro número si la lectura es CON buffer.
     */
    public void almacenadoNoVolatil(int modo){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            File archivo = new File("texto.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);

            if(modo == 1){
                for(int i = 0 ; i < 5 ; i++){
                    bw.write(String.valueOf(Lectura1()));
                    bw.newLine();
                    bw.flush();
                }
            }else{
                for(int i = 0 ; i < 5 ; i++){
                    bw.write(String.valueOf(Lectura2Buffer()));
                    bw.newLine();
                    bw.flush();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Punto1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }

                if (bw != null) {
                    bw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Punto1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

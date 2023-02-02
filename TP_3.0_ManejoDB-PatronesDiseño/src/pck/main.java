/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Redes05
 */
public class main {

    public static void main(String[] args) {
        
        Sistemita s = new Sistemita();
        String archivo = "datos.bin";
        
        try
        {
            s = s.deSerializar( archivo );
            Utilidades.mostrarPorPantalla("VIEJO");
            s.cargaBDD();
            
        }catch( IOException | ClassNotFoundException ex ){
            Utilidades.mostrarPorPantalla("NUEVO");
            s.creacion();
        }finally{
            s.prender();
        }
        
        try
        {
            s.serializar( archivo );
        }catch(IOException ex){
            System.out.println(ex);
            Utilidades.mensajeError( ex.getMessage() , "ERROR: No se pudo Serializar." );
        }
        
    }
    
}

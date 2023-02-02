/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Software-Notebook
 */
public class main {
    
    public static void main(String[] args) {

        //BaseDeUsuario b = new BaseDeUsuario();
        
        //BaseDeUsuario lista, TipoMembrecia membrecia, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto
        //Empleado e = new Empleado(b, 1, Puestos.Administrativo, 4324234, new Date(2010,6,6), "Carlos", "Fernandez", "Casa", 32, Genero.Femenino, "111111");
        
        
        Sistemita s = new Sistemita();
        String archivo = "datos.bin";
        
        try
        {
            s = s.deSerializar( archivo );
            Utilidades.mostrarPorPantalla("VIEJO");
        }catch( IOException | ClassNotFoundException ex ){
            s.creacion();
            Utilidades.mostrarPorPantalla("NUEVO");
        }finally{
            s.prender();
        }
        
        try
        {
            s.serializar( archivo );
        }catch(IOException ex){
            Utilidades.mensajeError( ex.getMessage() , "ERROR: No se pudo Serializar." );
        }
        
        
        
        
    }
    
}

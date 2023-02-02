/*
 * Este sistema tiene como finalidad la gestión de reservas de los eventos de una empresa. En el mismo
 * se podrán manipular dos bases de datos serializadas: Una de clientes y otra de reserva.
 * Ambas podrán crear, modificar, borrar y mostrar objetos dentro de ellas.
 */
package tp_2.pkg1_binario;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agust
 */
public class main {
    
    public static void main(String[] args) {
        
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
        
        try {
            s.serializar( archivo );
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}

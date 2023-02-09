/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.calle_ezequiel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.MAP;
import static jdk.internal.org.jline.keymap.KeyMap.key;

/**
 *
 * @author Redes-17
 */

class Almacen {
    PrintStream ps;
    Utilidades u = new Utilidades();
    
    public void agregarProducto(File f){
        //Ejecuta la primera opcion del menú, nos pide agregar el nombre, marca, cantidad y precios del producto
        u.leerTexto();
        u.mostrarMensaje("  +---------------------------------+");
        u.mostrarMensaje("  | Ingresar el nombre del producto |");
        u.mostrarMensaje("  +---------------------------------+");
        String nombre = u.leerTexto();
        
        u.mostrarMensaje("  +--------------------------------+");
        u.mostrarMensaje("  | Ingresar la marca del producto |");
        u.mostrarMensaje("  +--------------------------------+");
        String marca = u.leerTexto();

        u.mostrarMensaje("  +---------------------------------------------+");        
        u.mostrarMensaje("  | Ingresar la cantidad que lleva del producto |");
        u.mostrarMensaje("  +---------------------------------------------+");
        String cantidad = u.leerTexto();
        
        u.mostrarMensaje("  +--------------------------------+");
        u.mostrarMensaje("  | Ingrese el precio del producto |");
        u.mostrarMensaje("  +--------------------------------+");
        int precio = u.leerNumero();
        
        String texto = "_" + nombre + "_;_"
                             + marca+ "_;_"
                          + cantidad +"_;_"
                              + precio +"_";
        u.escribir(f, texto);
        
        
}
        
    public void calcularStock(File f){
        //En esta parte de codigo se calcula el stock de todos los productos
        
        Map<String, Integer> mapita  = new HashMap();
        ArrayList< Map<String, Integer>  > M = new ArrayList<>();
        
        int stock = 0;
        
        //les el archivo
        for( Map<String, Integer> item : M )
        {
            for( Map.Entry<String, Integer> key : mapita.entrySet() )
            {
                mapita.put( key.getKey() , 50 );

                if( M.contains( mapita )  )
                {
                    //sumar


                        stock += mapita.get( key.getKey() );
                        M.get(  M.indexOf(mapita) ).put( key.getKey()  , stock);


                }else{
                    //agrega
                    M.add(mapita);
                }
                
                u.mostrarMensaje("El stock del producto " + key.getKey() + " es de " + stock);
            }
            
            
        }
    }
    
}
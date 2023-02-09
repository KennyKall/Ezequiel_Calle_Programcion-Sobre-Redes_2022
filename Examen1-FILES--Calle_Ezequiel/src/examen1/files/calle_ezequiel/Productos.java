/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.files.calle_ezequiel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Redes-17
 */

public class Productos {
    PrintStream ps;
    Almacen a = new Almacen();
    File f = new File("datos.csv");
    Utilidades u = new Utilidades();
    VerProductos vp = new VerProductos();
    
    public void iniciar() 
    {//Realiza las acciones que se deben de ejecrutar luego de elegir una de las opciones que se nos da
        char op = ' ';
        while(op != '0'){
            op = Utilidades.menu(); 
            switch (op) {
            case '1':
                a.agregarProducto(f);
                break;
            case '2':
                vp.mostrarProductos(f);
                break;
            case '3':
                a.calcularStock(f);
                break;
            case '0':
                u.mostrarMensaje("  +--------------------------+");
                u.mostrarMensaje("  |.: Se cierra el almacen :.|");
                u.mostrarMensaje("  +--------------------------+");
            }
        }
    }
}
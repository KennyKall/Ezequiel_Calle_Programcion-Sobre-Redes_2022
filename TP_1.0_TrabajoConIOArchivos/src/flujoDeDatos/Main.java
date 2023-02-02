/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujoDeDatos;

import java.io.PrintStream;

/**
 *
 * @author Mendez Agustín 6°1
 */
public class Main {
    
    public static void main(String[] args) {
        PrintStream ps;
        ps = new PrintStream( System.out );
        
        Punto1 p1 = new Punto1();
        Punto2 p2 = new Punto2();
        
        int[] vector1;
        int[] vector2;
        
        ps.println("\n---------Almacenado volatil sin buffer---------"); 
        vector1 = p1.almacenadoVolatil();
        
        ps.println("\n---------Almacenado volatil con buffer---------"); 
        vector2 = p1.almacenadoVolatilConBuffer();
        
        ps.println("\n---------Almacenado no volatil sin buffer de entrada---------"); 
        p1.almacenadoNoVolatil(1);
        
        ps.println("\n---------Almacenado no Volatil con buffer de entrada---------"); 
        p1.almacenadoNoVolatil(2);
        
        p2.operacionDelVector(0, vector1);
        
    }
    
}

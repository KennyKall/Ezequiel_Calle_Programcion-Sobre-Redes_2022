/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujoDeDatosSimples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agust
 */
public class Main {
    static ClaseEjerciciosIO s = new ClaseEjerciciosIO();
    
    public static void main(String[] args) {
        int opcion = -1;
        
        while (opcion != 0){
            mostrarMenu();
            s.escribirConPrintStream("Ingrese una opción");
            opcion = Integer.parseInt(s.leerConSystem());
            
            switch(opcion){
                case 0:
                    s.escribirConPrintStream("Programa finalizado");
                    break;
                case 1:
                    s.ej1a();
                    break;
                case 2:
                    s.ej1b();
                    break;
                case 3:
                    s.ej1c();
                    break;
                case 4:
                    s.ej1d();
                    break;
                case 5:
                    s.ej1e();
                    break;
                case 6:
                    s.ej1f();
                    break;
                case 7:
                    s.ej1g();
                    break;
                case 8:
                    s.Ej2a();
                    break;
                case 9:
                    s.Ej2b();
                    break;
                case 10:
                    s.Ej2c();
                    break;
                case 11:
                    s.Ej2d();
                    break;
                case 12:
                    s.Ej2e();
                    break;
                case 13:
                    s.Ej2f();
                    break;
                case 14:
                    s.Ej2g();
                    break;
                case 15:
                    s.Ej2h();
                    break;
                case 16:
                    s.Ej3a();
                    break;
                case 17:
                    s.Ej3b();
                    break;
                case 18:
                    s.Ej3c();
                    break;
                case 19:
                    s.Ej3d();
                    break;
                case 20:
                    s.Ej3e();
                    break;
                case 21:
                    s.Ej3f();
                    break;
                case 22:
                    s.Ej3g();
                    break;
                default:
                    s.escribirConPrintStream("Ingrese un número válido...");
                    break;
            }
        }
    }
    
    public static void mostrarMenu(){
        s.escribirConPrintStream("-----------------MENÚ-----------------");
        s.escribirConPrintStream("-------------Ejercicio 1-------------");
        s.escribirConPrintStream("1 - Ejercicio 1A");
        s.escribirConPrintStream("2 - Ejercicio 1B");
        s.escribirConPrintStream("3 - Ejercicio 1C");
        s.escribirConPrintStream("4 - Ejercicio 1D");
        s.escribirConPrintStream("5 - Ejercicio 1E");
        s.escribirConPrintStream("6 - Ejercicio 1F");
        s.escribirConPrintStream("7 - Ejercicio 1G");
        s.escribirConPrintStream("-------------Ejercicio 2-------------");
        s.escribirConPrintStream("8 - Ejercicio 2A");
        s.escribirConPrintStream("9 - Ejercicio 2B");
        s.escribirConPrintStream("10 - Ejercicio 2C");
        s.escribirConPrintStream("11 - Ejercicio 2D");
        s.escribirConPrintStream("12 - Ejercicio 2E");
        s.escribirConPrintStream("13 - Ejercicio 2F");
        s.escribirConPrintStream("14 - Ejercicio 2G");
        s.escribirConPrintStream("15 - Ejercicio 2H");
        s.escribirConPrintStream("-------------Ejercicio 2-------------");
        s.escribirConPrintStream("16 - Ejercicio 3A");
        s.escribirConPrintStream("17 - Ejercicio 3B");
        s.escribirConPrintStream("18 - Ejercicio 3C");
        s.escribirConPrintStream("19 - Ejercicio 3D");
        s.escribirConPrintStream("20 - Ejercicio 3E");
        s.escribirConPrintStream("21 - Ejercicio 3F");
        s.escribirConPrintStream("22 - Ejercicio 3G");
    }
    
}

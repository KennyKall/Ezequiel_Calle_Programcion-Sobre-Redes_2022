/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase pondremos funcionalidaes basicas de comun uso.
 *
 * @author Software-Notebook
 */
public class Utilidades {

    private static PrintStream ps = null;
    private static InputStreamReader isr = null;
    private static BufferedReader br = null;

    /**
     * Muestra por consola un mensaje mediante un PrintStream
     * @param mensaje String mensaje a imprimir
     */
    public static void mostrarPorPantalla(String mensaje) {
        ps = new PrintStream(System.out);

        ps.println(mensaje);
    }

    /**
     * Muestra una lista de partidas jugadas
     * @param partidasJugadas 
     */
    public static void mostrarListaArray(ArrayList<Map<Integer, Integer>> partidasJugadas) {

        for (Map<Integer, Integer> item : partidasJugadas) {
            for (Map.Entry<Integer, Integer> puntuacion : item.entrySet()) {
                mostrarPorPantalla("\t\t\tPARTIDAS: \n"
                        + "\t\t " + puntuacion.getKey()
                        + "\t\t " + puntuacion.getValue()
                );
            }
        }
    }

    /**
     * Procesa un error y lo escribe en un archivo 'crash.log'.
     * @param ex excepcion
     * @param error 
     */
    public static void mensajeError(String ex, String error) {
//        ps = new PrintStream(System.err);
//
//        ps.println(error
//                + "\n"
//                + ex
//        );

        //COMPLETAR USTEDES
        //
        // todos los errores salen por este metodo
        // sale por defecto a un crash.log
        //
        //COMPLETAR USTEDES  
        
        //COMPLETADO
        
        PrintStream Ps;
        File archivo = new File("crash.log");
        try {
            
            FileOutputStream fos = new FileOutputStream(archivo,true);
            Ps = new PrintStream( fos );
            System.setErr( Ps );
        } catch (FileNotFoundException e) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, e);
        }
        
        String msj = error + "; " + ex;
        Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, msj);
        System.err.println(msj);
    }

    /**
     * Lee el primer caracter ingresado por consola
     * @return caracter
     */
    static char obtenerOpcion() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        char opt = 0;
        try {
            opt = br.readLine().charAt(0);
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return opt;
    }

    /**
     * Lee un número ingresado por consola
     * @return número ingresado
     */
    static int leerNumero() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            return 0;
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Muestra los puestos posibles a elegir y lee la opción para definir el puesto
     * @return puesto
     */
    public static Puestos elegirPuesto() {
        char op;
        do {
//            try {
//                Runtime.getRuntime().exec("cls");
//            } catch (IOException ex) {
//                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
//            }
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Puestos p : Puestos.values()) {
                opciones += "\t\t\t[" + (p.ordinal() + 1) + "] " + p.name() + "\n";
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < '1' || Character.getNumericValue(op) > Puestos.values().length);

        return Puestos.values()[Character.getNumericValue(op) - 1];
    }
    
    /**
     * Muestra las membresias posibles a elegir y lee la opción para definir la membresia
     * @return membresia
     */
    public static TipoMembrecia elegirMembresia() {
        char op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (TipoMembrecia m : TipoMembrecia.values()) {
                opciones += "\t\t\t[" + (m.ordinal() + 1) + "] " + m.name() + "\n";
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < '1' || Character.getNumericValue(op) > TipoMembrecia.values().length);

        return TipoMembrecia.values()[Character.getNumericValue(op) - 1];
    }

    /**
     * Lee una fecha ingresada por consola
     * @return fecha
     */
    static Date leerFecha() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        Date fecha;

        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            fecha = df.parse(br.readLine());

            return fecha;
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return (new Date("00/00/0000"));
        }
    }

    /**
     * Lee una línea ingresada por consola
     * @return texto
     */
    static String leerTexto() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        String texto = "";
        try {
            texto = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }

        return texto;
    }

    /**
     * Muestra los generos posibles a elegir y lee la opción para definir el género
     * @return genero
     */
    static Genero leerGenero() {
        char op;
        do {
            String opciones = "\n\t\tMENU DE OPCIONES\n\n";
            for (Genero g : Genero.values()) {
                opciones += "\t\t\t[" + (g.ordinal() + 1) + "] " + g.name() + "\n";
            }
            mostrarPorPantalla(opciones);
            op = Utilidades.obtenerOpcion();
        } while (op < '1' || Character.getNumericValue(op) > Puestos.values().length);

        return Genero.values()[Character.getNumericValue(op) - 1];
    }

}

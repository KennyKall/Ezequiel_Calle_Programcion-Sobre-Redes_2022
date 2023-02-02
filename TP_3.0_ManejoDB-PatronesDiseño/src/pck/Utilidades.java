/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.BufferedReader;
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

    public static void mostrarPorPantalla(String mensaje) {
        ps = new PrintStream(System.out);

        ps.println(mensaje);
    }

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
        Object[] msg = {ex, error};
        Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, msg);
    }

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


}

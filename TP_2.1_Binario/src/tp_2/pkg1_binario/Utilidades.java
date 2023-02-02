/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

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
 * @author agust
 */
public class Utilidades {

    private static PrintStream ps = null;
    private static InputStreamReader isr = null;
    private static BufferedReader br = null;

    public static void mostrarPorPantalla(String mensaje) {
        ps = new PrintStream(System.out);

        ps.println(mensaje);
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

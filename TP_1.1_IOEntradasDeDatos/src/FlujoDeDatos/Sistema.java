/*
 * Esta clase incluye los métodos correspondientes a la solución del TP 1.1:
 *   Pedir al usuario que ingrese por consola una operación aritmética (+ - * /)
 *   Leer por consola sin usar la clase Scanner.
 *   Procesar la cadena de texto de forma que se realice a operación y devolverla por
 *   consola
 *   Volver a pedirle al usuario otra operación hasta que le dé a la opción salir.
 */
package FlujoDeDatos;

import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mendez Agustín 6°1
 */
public class Sistema {
    PrintStream ps;
    
    /**
     * Este método escribe un texto en la consola mediante PrintStream.
     * @param texto texto a escribir.
     */
    public void escribir(String texto){
        ps = new PrintStream(System.out);
        ps.println( texto );
    }
    
    /**
     * Este método lee la consola utilizando la clase system.
     * @return texto leído.
     */
    public String leer(){
        String texto = "";
        int Byte = -1;
        
        try {
            while(  (Byte = System.in.read()) != '\n'  )
            {
                texto = texto + (char)Byte;
            }
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return texto;
    }
    
    /**
     * Este método se encarga de solicitar al usuario una opción y, utilizando
     * un switch, brindar un resultado acorde a la operación seleccionada.
     * El programa finaliza cuando el usuario ingresa "0".
     */
    public void cuentas(){
        String operacion = "";
        int n1;
        int n2;
        int resultado;
        
        while (operacion.compareTo("0") != 0){
            escribir("Ingrese una operación (0 para salir): ");
            operacion = leer();
            
            if (operacion.compareTo("0") == 0){
                continue;
            }
            
            escribir("Ingrese el primer número: ");
            n1 = Integer.parseInt(leer());
            escribir("Ingrese el segundo número: ");
            n2 = Integer.parseInt(leer());
            
            switch(operacion) {
                case "+":
                    resultado = n1+n2;
                    escribir(n1 + " + " + n2 + " = " + resultado);
                    break;
                case "-":
                    resultado = n1-n2;
                    escribir(n1 + " - " + n2 + " = " + resultado);
                    break;
                case "*":
                    resultado = n1*n2;
                    escribir(n1 + " * " + n2 + " = " + resultado);
                    break;
                case "/":
                    resultado = n1/n2;
                    escribir(n1 + " / " + n2 + " = " + resultado);
                    break;
                default:
                    escribir("Operación no válida");
                    break;
            }
        }
        
        escribir("Programa finalizado...");
        
    }
}

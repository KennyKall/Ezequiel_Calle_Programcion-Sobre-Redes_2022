/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujoDeDatosSimples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agust
 */
public class ClaseEjerciciosIO {
    
    InputStreamReader is;
    BufferedReader br;
    PrintStream ps;
    
    /**
     * Este método lee la consola con un buffer de lectura y devuelve el texto.
     * @return texto leído.
     */
    public String leerConBuffer() {
        is = new InputStreamReader( System.in );
        br = new BufferedReader( is );
        String texto = "";
        
        try {
            texto = br.readLine();
            return texto;
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return texto;
    }
    
    /**
     * Este método lee la consola utilizando únicamente la clase system.
     * @return texto leído.
     */
    public String leerConSystem(){
        String texto = "";
        int Byte = -1;
        
        try {
            while(  (Byte = System.in.read()) != '\n'  )
            {
                texto = texto + (char)Byte;
            }
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return texto;
    }
    
    /**
     * Este método escribe un texto mediante PrintStream.
     * @param texto texto a escribir.
     */
    public void escribirConPrintStream(String texto){
        ps = new PrintStream(System.out);
        ps.println( texto );
    }
    
    /**
     * Ej 1a: Dados el valor de una hora de trabajo y la cantidad de horas trabajadas, la computadora muestra el valor del sueldo bruto.
     */
    public void ej1a(){
        escribirConPrintStream("Ingrese el valor de la hora de trabajo: ");
        float vh = Float.parseFloat(leerConSystem());
        escribirConPrintStream("Ingrese la cantidad de horas trabajadas: ");
        int ch = Integer.parseInt(leerConSystem());
        
        float vf = vh*ch;
        
        escribirConPrintStream("Sueldo bruto: " + vf);
    }
    
    /**
     * Ej 1b: Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante.
     */
    public void ej1b(){
        escribirConPrintStream("Ingrese el valor del primer ángulo del rectángulo: ");
        int a1 = Integer.parseInt(leerConSystem());
        escribirConPrintStream("Ingrese el valor del segundo ángulo del rectángulo: ");
        int a2 = Integer.parseInt(leerConSystem());
        
        int vf = 180 - a1 - a2;
        
        escribirConPrintStream("Ángulo restante: " + vf);
    }
    
    /**
     * Ej 1c: Dada la superficie de un cuadrado (en m2), la computadora muestra su perímetro.
     */
    public void ej1c(){
        escribirConPrintStream("Ingrese el valor de la superficie del cuadrado: ");
        int s = Integer.parseInt(leerConSystem());
        
        double vf = Math.sqrt(s);
        
        escribirConPrintStream("Perímetro del cuadrado: " + vf);
    }
    
    /**
     * Ej 1d: Dada una temperatura en grados Fahrenheit, la computadora la muestra en grados centígrados.
     */
    public void ej1d(){
        escribirConPrintStream("Ingrese la temperatura en Fahrenheit: ");
        float tf = Float.parseFloat(leerConSystem());
        
        double vf = (tf - 32) * 0.5556;
        
        escribirConPrintStream("La temperatura en celsius es: " + vf);
    }
    
    /**
     * Ej 1d: Dado un tiempo en segundos, la computadora lo muestra expresado en días, horas, minutos y segundos.
     */
    public void ej1e(){
        escribirConPrintStream("Ingrese el tiempo en segundos: ");
        int s = Integer.parseInt(leerConSystem());
        
        int dia = (int)TimeUnit.SECONDS.toDays(s);
        long horas = TimeUnit.SECONDS.toHours(s) - (dia *24);
        long minutos = TimeUnit.SECONDS.toMinutes(s) - (TimeUnit.SECONDS.toHours(s)* 60);
        long segundos = TimeUnit.SECONDS.toSeconds(s) - (TimeUnit.SECONDS.toMinutes(s) *60);
        
        escribirConPrintStream(dia + " días / Hora = " + horas + ":" + minutos + ":" + segundos);
    }
    
    /**
     * Ej 1f: Dado el precio de un artículo, la computadora muestra los valores a
     * pagar según cada plan. Una casa de artículos para el hogar ofrece a sus clientes los siguientes planes de pago:
     * i. Plan 1: 100% al contado. Se hace el 10% de descuento sobre el precio publicado.
     * ii. Plan 2: 50% al contado y el resto en 2 cuotas iguales. El precio publicado se incrementa en un 10%.
     * iii. Plan 3: 25% al contado y el resto en 5 cuotas iguales. El precio publicado se incrementa en un 15%.
     * iv. Plan 4: Totalmente financiado en 8 cuotas. El 60% se reparte en partes iguales en las primeras 4 cuotas
     * y el resto se reparte en partes iguales en las últimas 4 cuotas. El precio publicado se incrementa en un 25%.
     */
    public void ej1f(){
        escribirConPrintStream("Ingrese el precio: ");
        float precio = Float.parseFloat(leerConSystem());
        
        /*Plan 1*/
        double resultado1 = precio - precio*0.1;
        
        /*Plan 2*/
        double resultado2 = (precio + precio*0.1);
        double contado2 = resultado2/2;
        double cuotaPlan2 = resultado2/4;
        
        /*Plan 3*/
        double resultado3 = (precio + precio*0.15);
        double contado3 = resultado2/4;
        double cuotaPlan3 = (resultado3*0.75)/5;
        
        /*Plan 4*/
        double resultado4 = (precio + precio*0.25);
        double cuotaPlan4 = (resultado4*0.60)/4;
        double cuota2Plan4 = (resultado4*0.40)/4;
        
        escribirConPrintStream("Plan 1: " + resultado1);
        
        escribirConPrintStream("Plan 2: "
                + "\n - Contado: " + contado2
                + "\n - Cuota 1: " + cuotaPlan2
                + "\n - Cuota 2: " + cuotaPlan2
                + "\n - Total: " + resultado2);
        
        escribirConPrintStream("Plan 3: "
                + "\n - Contado: " + contado3
                + "\n - 5 cuotas de: " + cuotaPlan3
                + "\n - Total: " + resultado3);
        
        
        escribirConPrintStream("Plan 4: "
                + "\n - Primeras 4 cuotas de: " + cuotaPlan4
                + "\n - Restantes 4 cuotas de: " + cuota2Plan4
                + "\n - Total: " + resultado4);
         
        
    }
    
    /**
     * Ej 1g: Dado el signo zodiacal del usuario, la computadora muestra su mes de nacimiento aproximado.
     */
    public void ej1g(){
        escribirConPrintStream("Ingrese su signo zodiacal: ");
        String signo = leerConSystem();
        signo = signo.toLowerCase();
        
        switch(signo){
            case "aries":
                escribirConPrintStream("Naciste en marzo o abril");
                break;
            case "tauro":
                escribirConPrintStream("Naciste en abril o mayo");
                break;
            case "geminis":
                escribirConPrintStream("Naciste en mayo o junio");
                break;
            case "cancer":
                escribirConPrintStream("Naciste en junio o julio");
                break;
            case "leo":
                escribirConPrintStream("Naciste en julio o agosto");
                break;
            case "virgo":
                escribirConPrintStream("Naciste en agosto o septiembre");
                break;
            case "libra":
                escribirConPrintStream("Naciste en septiembre u octubre");
                break;
            case "escorpio":
                escribirConPrintStream("Naciste en octubre o noviembre");
                break;
            case "sagitario":
                escribirConPrintStream("Naciste en noviembre o diciembre");
                break;
            case "capricornio":
                escribirConPrintStream("Naciste en diciembre o enero");
                break;
            case "acuario":
                escribirConPrintStream("Naciste en enero o febrero");
                break;
            case "piscis":
                escribirConPrintStream("Naciste en febrero o marzo");
                break;
            
        }
        
    }
    
    /**
     * Dados tres apellidos, la computadora los muestra ordenados alfabéticamente.
     */
    public void Ej2a(){
        String[] apellidos = new String[3];
        
        escribirConPrintStream("Ingrese el 1er apellido: ");
        apellidos[0] = leerConBuffer();
        escribirConPrintStream("Ingrese el 2do apellido: ");
        apellidos[1] = leerConBuffer();
        escribirConPrintStream("Ingrese el 3er apellido: ");
        apellidos[2] = leerConBuffer();
        
        int i, j;
        String aux;
        for (i = 0; i < apellidos.length - 1; i++) {
            for (j = 0; j < apellidos.length - i - 1; j++) {                                                              
                if (apellidos[j + 1].compareTo(apellidos[j]) < 0) {
                    aux = apellidos[j+1];
                    apellidos[j + 1] = apellidos[j];
                    apellidos[j] = aux;
                }
            }
        }
        
        escribirConPrintStream("Apellido 1: " + apellidos[0]);
        escribirConPrintStream("Apellido 2: " + apellidos[1]);
        escribirConPrintStream("Apellido 3: " + apellidos[2]);
    }
    
    /**
     * Dados cuatro números reales, la computadora indica cuál es el menor.
     */
    public void Ej2b(){
        
        double[] lista = new double[4];
        
        for(int i=0;i<4;i++){
            escribirConPrintStream("Ingrese el N° " + i + ": ");
            lista[i] = Double.parseDouble(leerConBuffer());
        }
        
        double menor = lista[0];
        
        for(int i = 1; i < lista.length ; i++){
            if (lista[i] < menor) {
                menor = lista[i];
            }
        }
        
        escribirConPrintStream("El menor es: " + menor);
        
    }
    
    /**
     * Dado un número, la computadora indica si es par o impar.
     */
    public void Ej2c(){
        escribirConPrintStream("Ingrese un número entero: ");
        int n = Integer.parseInt(leerConBuffer());
        if((n%2) == 0) {
            escribirConPrintStream("El número " + n + " es par");
        }else{
            escribirConPrintStream("El número " + n + " es impar");
        }
    }
    
    /**
     * Dados dos números reales, la computadora indica si el mayor es
divisible por el menor.
     */
    public void Ej2d(){
        escribirConPrintStream("Ingrese un número real: ");
        double n = Double.parseDouble(leerConBuffer());
        escribirConPrintStream("Ingrese el segundo número real: ");
        double n2 = Double.parseDouble(leerConBuffer());
        
        if(n < n2){
            if (n2%n == 0){
                escribirConPrintStream("El número " + n2 + " es divisible por " + n);
            }else {
                escribirConPrintStream("El número " + n2 + " NO es divisible por " + n);
            }
        }else{
            if (n%n2 == 0){
                escribirConPrintStream("El número " + n + " es divisible por " + n2);
            }else {
                escribirConPrintStream("El número " + n + " NO es divisible por " + n2);
            }
        }
    }
    
    /**
     * Dada la fecha de nacimiento de una persona, la computadora
muestra su signo del zodíaco.
     */
    public void Ej2e(){
        escribirConPrintStream("Ingrese el día de su nacimiento");
        int dia = Integer.parseInt(leerConBuffer());
        escribirConPrintStream("Ingrese el mes de su nacimiento (en número)");
        int mes = Integer.parseInt(leerConBuffer());
        
        Date fecha = new Date(2000,mes,dia);
        if ((fecha.after(new Date(2000,1,21))) && (fecha.before(new Date(2000,2,19)))){
            escribirConPrintStream("Tu signo es Acuario");
        }
        if ((fecha.after(new Date(2000,2,20))) && (fecha.before(new Date(2000,3,20)))){
            escribirConPrintStream("Tu signo es Piscis");
        }
        if ((fecha.after(new Date(2000,3,21))) && (fecha.before(new Date(2000,4,20)))){
            escribirConPrintStream("Tu signo es Aries");
        }
        if ((fecha.after(new Date(2000,4,21))) && (fecha.before(new Date(2000,5,20)))){
            escribirConPrintStream("Tu signo es Tauro");
        }
        if ((fecha.after(new Date(2000,5,21))) && (fecha.before(new Date(2000,6,20)))){
            escribirConPrintStream("Tu signo es Géminis");
        }
        if ((fecha.after(new Date(2000,6,21))) && (fecha.before(new Date(2000,7,20)))){
            escribirConPrintStream("Tu signo es Cancer");
        }
        if ((fecha.after(new Date(2000,7,21))) && (fecha.before(new Date(2000,8,21)))){
            escribirConPrintStream("Tu signo es Leo");
        }
        if ((fecha.after(new Date(2000,8,22))) && (fecha.before(new Date(2000,9,20)))){
            escribirConPrintStream("Tu signo es Virgo");
        }
        if ((fecha.after(new Date(2000,9,21))) && (fecha.before(new Date(2000,10,20)))){
            escribirConPrintStream("Tu signo es Libra");
        }
        if ((fecha.after(new Date(2000,10,21))) && (fecha.before(new Date(2000,11,21)))){
            escribirConPrintStream("Tu signo es Escorpio");
        }
        if ((fecha.after(new Date(2000,11,22))) && (fecha.before(new Date(2000,12,21)))){
            escribirConPrintStream("Tu signo es Sagitario");
        }
        if ((fecha.after(new Date(2000,12,22))) && (fecha.before(new Date(2000,1,20)))){
            escribirConPrintStream("Tu signo es Capricornio");
        }
    }
    
    /**
     * Dado el nombre y apellido de 2 personas, la computadora muestra
cuál de los 2 tiene el apellido más largo.
     */
    public void Ej2f(){
        escribirConPrintStream("Ingrese el apellido de la primer persona: ");
        String a1 = leerConBuffer();
        escribirConPrintStream("Ingrese el apellido de la segunda persona: ");
        String a2 = leerConBuffer();
        
        if(a1.length() < a2.length()){
            escribirConPrintStream("El apellido " + a2 + " es el apellido más largo");
        }else if(a1.length() > a2.length()){
            escribirConPrintStream("El apellido " + a1 + " es el apellido más largo");
        }else{
            escribirConPrintStream("Los apellidos tienen la misma longitud");
        }
        
    }
    
    /**
     * Dado un entero N natural, la computadora muestra su tabla de multiplicar.
     */
    public void Ej2g(){
        escribirConPrintStream("Ingrese un número natural: ");
        int n = Integer.parseInt(leerConBuffer());
        
        for(int i = 1; i < 11 ; i++){
            escribirConPrintStream(n + " x " + i + " = " + n*i);
        }
    }
    
    /**
     * Dado un número natural, la computadora indica si es primo o no.
     */
    public void Ej2h(){
        escribirConPrintStream("Ingrese un número natural: ");
        int n = Integer.parseInt(leerConBuffer());
        
        boolean primo = true;
        int count = n - 1;
        while(primo && count > 1){
            if(n%count == 0){
                primo = false;
            }
            count--;
        }
        
        if(primo){
            escribirConPrintStream("El número " + n + " es primo");
        }else {
            escribirConPrintStream("El número " + n + " NO es primo");
        }
    }
    
    /**
     * Crear un archivo de texto (en la carpeta del proyecto) que guarde solo el último
dato que el usuario escribe por consola.
     */
    public void Ej3a(){
        escribirConPrintStream("Ingrese algo: ");
        String dato = leerConBuffer();
        
        FileWriter fw = null;
        PrintWriter pw = null;
        File f = new File("dato.txt");

        try {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            fw = new FileWriter(f, true);

            pw = new PrintWriter(fw);
            pw.println(dato);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /**
     * Crear un archivo de texto (en la carpeta del proyecto) que guarde TODOS los
valores NUMERICOS que ingrese el usuario por consola, cada uno en un renglón
(puede ingresar otros datos que no sean numero OJO).
     */
    public void Ej3b(){
        
        File f = new File("dato.txt");

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        FileWriter fw = null;
        PrintWriter pw = null;
        String dato = "";
        boolean contieneNumero = false;
        
        while(dato.compareTo("0") != 0){
            String c;
            try{
                fw = new FileWriter(f, true);
                pw = new PrintWriter(fw);

                
                for(int i = 0; i < dato.length(); i++){
                    c = Character.toString(dato.charAt(i));
                    if("0123456789-".contains(c)){
                        pw.print(c);
                        contieneNumero = true;
                    }
                }
                if (contieneNumero){
                    pw.print("\n");
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (pw != null) {
                        pw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            escribirConPrintStream("Ingrese un número: ");
            dato = leerConBuffer();
        }
    }
    
    /**
     * Crear un archivo de texto (fuera de la carpeta del proyecto) que se llame
“números.txt” que guarde los números pares desde el 0 al 1000.
     */
    public void Ej3c(){
        FileWriter fw = null;
        PrintWriter pw = null;
        File f = new File("D:\\Agustin\\Escritorio\\numeros.txt");

        try {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            fw = new FileWriter(f, true);

            pw = new PrintWriter(fw);
            for(int i = 0; i <= 1000; i++){
                if (i%2 == 0){
                    pw.println(i);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Utilizar el archivo creado anteriormente “números.txt” y leer los valores para
mostrarlos por la consola.
     */
    public void Ej3d(){
        File f = new File("D:\\Agustin\\Escritorio\\numeros.txt");
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            while ((linea = br.readLine()) != null) {
                escribirConPrintStream(linea);
            }

            br.close();
            fr.close();
        }catch (IOException e) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Utilizar el archivo creado anteriormente “números.txt” y borrarle todos los
renglones que contengas números impares.
     */
    public void Ej3e(){
        File f = new File("D:\\Agustin\\Escritorio\\numeros.txt");
        File fn = new File("D:\\Agustin\\Escritorio\\numeros_nuevo.txt");
        
        try {
            fn.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            int n = 0;
            fw = new FileWriter(fn, true);

            pw = new PrintWriter(fw);
            while ((linea = br.readLine()) != null) {
                n = Integer.parseInt(linea);
                if (n%2 == 0){
                    pw.println(linea);
                }
            }

            br.close();
            fr.close();
        }catch (IOException e) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            f.delete();

            File ff = new File("D:\\Agustin\\Escritorio\\numeros.txt");
            fn.renameTo(ff);
        }catch (NullPointerException e){
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    /**
     * Utilizar el archivo creado anteriormente “números.txt” (con los números impares
eliminados) y colocar en otro archivos de texto “primos.dat” (fuera de la carpeta
del proyecto y de la carpeta que tiene el archivo “números.txt”) todos los números
de ”números.txt” que sean primos.
     */
    public void Ej3f(){
        File f = new File("D:\\Agustin\\Escritorio\\numeros.txt");
        File fn = new File("D:\\Agustin\\Documentos\\primos.dat");
        
        try {
            fn.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            int n = 0;
            fw = new FileWriter(fn, true);

            pw = new PrintWriter(fw);
            while ((linea = br.readLine()) != null) {
                n = Integer.parseInt(linea);
                boolean primo = true;
                int count = n - 1;
                while(primo && count > 1){
                    if(n%count == 0){
                        primo = false;
                    }
                    count--;
                }
                if(primo){
                    pw.println(linea);
                }
            }

            br.close();
            fr.close();
        }catch (IOException e) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Crear un archivo de texto plano (fuera de la carpeta del proyecto) que se llame
“caracteres.dat”, cargarle 10 palabras que contengan la letra ‘ñ’ mediante
consola. Luego mostrar las 10 palabras por consola con la leyenda “Fichero
original: ” y luego editar el fichero para que cambie todas las apariciones de la
letra ‘ñ’ por su fonético ‘nie-nio’ y mostrar de nuevo las palabras con la leyenda
“Fichero arreglado:”.
     */
    public void Ej3g(){
        FileWriter fw = null;
        PrintWriter pw = null;
        FileWriter fw2 = null;
        PrintWriter pw2 = null;
        File f = new File("D:\\Agustin\\Documentos\\caracteres.dat");
        File fn = new File("D:\\Agustin\\Documentos\\caracteres_nuevo.dat");

        try {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);
            
            for(int i = 0; i < 5; i++){
                escribirConPrintStream("Ingrese la palabra con 'ñ' N°" + i + ": ");
                pw.println(leerConBuffer());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try{
            
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            escribirConPrintStream("Fichero original:");
            
            String linea = "";
            while ((linea = br.readLine()) != null) {
                escribirConPrintStream(linea);
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            escribirConPrintStream("\nFichero arreglado:");
            
            fw2 = new FileWriter(fn, true);
            pw2 = new PrintWriter(fw2);
            
            FileReader fr2 = new FileReader(f);
            BufferedReader br2 = new BufferedReader(fr2);
            
            String linea2 = "", palabra = "";
            while ((linea2 = br2.readLine()) != null) {
                if(linea2.contains("�")){
                    palabra = linea2.replace("�", "ni");
                }else{
                    palabra = linea2;
                }
                
                pw2.println(palabra);
                escribirConPrintStream(palabra);
            }
            
            fr2.close();
            br2.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pw2 != null) {
                    pw2.close();
                }

                if (fw2 != null) {
                    fw2.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            f.delete();
            
            File ff = new File("D:\\Agustin\\Documentos\\caracteres.dat");
            fn.renameTo(ff);
        }catch (NullPointerException e){
            Logger.getLogger(ClaseEjerciciosIO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import static FlujoDeDatos.FileObjectBinary.Utilidades.mostrarPorPantalla;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Software-Notebook
 */
public class Socio extends Persona {

    private float cuota;
    private TipoMembrecia membrecia; //Enum    
    // (numero hoyo , puntos)
    private ArrayList< Map<Integer, Integer>> partidasJugadas;
    private BaseDeUsuario usuarios;

    public Socio(BaseDeUsuario lista, TipoMembrecia membrecia, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.cuota = -1;
        this.membrecia = membrecia;
        this.partidasJugadas = new ArrayList<>();
        this.usuarios = lista;
    }

    /**
     * Modifica el valor de la cuota según la membresia y antiguedad
     */
    @Override
    public void calcular() {
        //COMPLETAR USTEDES
        //
        // cambia segun la antiguedad
        //
        //COMPLETAR USTEDES
        
        //COMPLETADO
        
        switch (this.membrecia) {
            case Bronce:
                this.cuota = 5000;
                break;
            case Plata:
                this.cuota = 10000;
                break;
            case Oro:
                this.cuota = 20000;
                break;
            case Black:
                this.cuota = 50000;
                break;
            case Platino:
                this.cuota = 100000;
                break;
        }
        
        long añoActual = new Date(System.currentTimeMillis()).getYear() + 1900;
        int antiguedad = (int) añoActual - this.fechaDeIngreso.getYear();
        
        if (antiguedad < 2){
            this.cuota = this.cuota;
        }else if(antiguedad < 5){
            this.cuota -= this.cuota * 0.2;
        }else if(antiguedad < 10){
            this.cuota -= this.cuota * 0.3;
        }else if(antiguedad > 10){
            this.cuota -= this.cuota * 0.5;
        }
    }

    /**
     * Muestra los datos del socio por consola
     */
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("SOCIO: \n"
                + "\t NOMBRE: " + this.nombre + "\n"
                + "\t APELLIDO: " + this.apellido + "\n"
                + "\t DIRECCION: " + this.direccion + "\n"
                + "\t GENERO: " + this.genero + "\n"
                + "\t TEL: " + this.numContacto + "\n"
                + "\t DNI: " + this.DNI + "\n"
                + "----------------------\n"
                + "\t CUOTA: " + this.cuota + "\n"
                + "\t MEMBRECIA: " + this.membrecia + "\n"
                + "....................................\n"
        );

        Utilidades.mostrarListaArray(this.partidasJugadas);
        Utilidades.mostrarPorPantalla("+ \"==================================\\n\"");
    }

    /**
     * Muestra el menú de socios por consola, solicita y procesa la opción elegida
     * @return variable continuar en falso para determinar que el usuario salió del menú
     */
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                //COMPLETAR USTEDES
                //
                // agregar opcion para cambiar membresia.
                // verificar que que no explote las cargas de datos nuevos
                // ni los pedidos de mostrar datos far falta de ellos.
                //
                //COMPLETAR USTEDES
                
                //COMPLETADO
                
                mostrarPorPantalla(
                        "\tMENÚ SOCIO\n\n"
                        + "\t[1] Cargar un Socio\n"
                        + "\t[2] Cargar un Partidas de un Socio\n"
                        + "\t[3] Calcular Cuota\n"
                        + "\t[4] Mostrar Socios\n"
                        + "\t[5] Mostrar Partidas por socios\n"
                        + "\t[6] Cambiar Membresia\n"
                        + "\t[7] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '7');

            switch (op) {
                case '1':
                    this.cargarNuevoSocio();
                    break;
                case '2':
                    this.cargarPartida((Socio) usuarios.elegirUsuario(Socio.class));
                    break;
                case '3':
                    usuarios.actualizarSueldosCoutas();
                    break;
                case '4':
                    usuarios.mostrarPersonas(Socio.class);
                    break;
                case '5':
                    usuarios.mostrarPartidasSocios();
                    break;
                case '6':
                    this.cambiarMembresia((Socio) usuarios.elegirUsuario(Socio.class));
                    break;
                case '7':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /**
     * Muestra un mensaje por pantalla del usuario jugando.
     */
    @Override
    public void proceder() {

        Utilidades.mostrarPorPantalla("JUEGA PLACIDAMENTE");

    }

    /**
     * Lee todos los datos de un nuevo socio, crea un objeto con los mismos y lo agrega
     * a la lista de la base de usuarios.
     */
    private void cargarNuevoSocio() {
        Utilidades.mostrarPorPantalla("Ingrese la membresia: ");
        TipoMembrecia membresia = Utilidades.elegirMembresia();
        Utilidades.mostrarPorPantalla("Ingrese el dni: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Fecha de Ingreso: ");
        Date fecha = Utilidades.leerFecha();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Direcion: ");
        String direccion = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Edad: ");
        int edad = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Genero: ");
        Genero gen = Utilidades.leerGenero();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String tel = Utilidades.leerTexto();

        //BaseDeUsuario lista, TipoMembrecia membrecia, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto
        Socio s = new Socio(usuarios, membresia, dni, fecha, nombre, apellido, direccion, edad, gen, tel);

        usuarios.agregarUsuario(s);
    }
    
    /**
     * Solicita los datos de una partida y la carga en la lista de partidas.
     * @param s objeto socio
     */
    public void cargarPartida(Socio s) {
        Map<Integer,Integer> partida = new HashMap<>();
        
        int i = 0;
        int puntos = 0;
        while (puntos != -1){
            i++;
            
            Utilidades.mostrarPorPantalla("Ingrese los puntos de la ronda n°" + i + " (-1 para terminar): ");
            puntos = Utilidades.leerNumero();
            
            partida.put(i, puntos);
        }
        
        s.partidasJugadas.add(partida);
    }
    
    /**
     * Solicita una nueva membresia y modifica el atributo del socio que contiene la misma.
     * @param s objeto socio
     */
    public void cambiarMembresia(Socio s){
        Utilidades.mostrarPorPantalla("Ingrese la nueva membresia: ");
        TipoMembrecia m = Utilidades.elegirMembresia();
        
        s.membrecia = m;   
    }
    
    /**
     * Muestra por consola todas las partidas del socio.
     */
    public void mostrarPartidas(){
        for (int i = 0; i < this.partidasJugadas.size(); i++){
            Utilidades.mostrarPorPantalla("------Partida n°: " + (i + 1) + "------");
            for (Map.Entry<Integer, Integer> e : this.partidasJugadas.get(i).entrySet()) {
                Utilidades.mostrarPorPantalla("Ronda N°" + e.getKey() + ": " + e.getValue() + " puntos");
            }
        }
    }
}

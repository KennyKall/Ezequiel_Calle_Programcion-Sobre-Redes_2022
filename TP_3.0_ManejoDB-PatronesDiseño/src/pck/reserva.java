/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author agust
 */
public class reserva implements Serializable, GeneralDTO{
    private int id;
    private Date fecha;
    private String horario;
    private String localidad;
    private int precio;
    private HashSet<comida> comidasIncluidas;
    private BaseDeDatos reservas;

    public reserva(BaseDeDatos lista, Date fecha, String horario, String localidad, int precio) {
        this.fecha = fecha;
        this.horario = horario;
        this.localidad = localidad;
        this.precio = precio;
        this.reservas = lista;
        this.comidasIncluidas = new HashSet<comida>();
    }
    
    public reserva(int id, Date fecha, String horario, String localidad, int precio) {
        this.fecha = fecha;
        this.id = id;
        this.horario = horario;
        this.localidad = localidad;
        this.precio = precio;
        this.comidasIncluidas = new HashSet<comida>();
    }
   
    public void agregarComida(comida e){
        comidasIncluidas.add(e);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public HashSet<comida> getComidasIncluidas() {
        return comidasIncluidas;
    }

    public void setComidasIncluidas(HashSet<comida> comidasIncluidas) {
        this.comidasIncluidas = comidasIncluidas;
    }

    public BaseDeDatos getReservas() {
        return reservas;
    }

    public void setReservas(BaseDeDatos reservas) {
        this.reservas = reservas;
    }
    
    
    
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                Utilidades.mostrarPorPantalla(
                        "\tMENÚ RESERVAS\n\n"
                        + "\t[1] Cargar una reserva\n"
                        + "\t[2] Mostrar Reservas\n"
                        + "\t[3] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '1':
                    this.cargarNuevaReserva();
                    break;
                case '2':
                    reservas.mostrarReservas();
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }
    
    
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("RESERVA: \n"
                + "\t Fecha: " + this.fecha.toString() + "\n"
                + "\t Horario: " + this.horario + "\n"
                + "\t Localidad: " + this.localidad + "\n"
                + "\t Precio: " + this.precio + "\n"
                + "\t Comidas Incluidas: "
        );
        for (comida c : comidasIncluidas) {
            c.mostrarDatos();
        }
        Utilidades.mostrarPorPantalla("\n==================================\n");
    }    
    
    public void cargarNuevaReserva() {

        Utilidades.mostrarPorPantalla("Ingrese el año del evento: ");
        int anio = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el mes del evento: ");
        int mes = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el dia del evento: ");
        int dia = Utilidades.leerNumero();
        Date Fecha = new Date(anio,mes,dia);
        
        Utilidades.mostrarPorPantalla("Ingrese el horario: ");
        String Horario = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese la localidad: ");
        String Localidad = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el precio: ");
        int Precio = Utilidades.leerNumero();
        
        Utilidades.mostrarPorPantalla("¿Cuantas comidas desea ingresar? (0 en caso de ninguna) ");
        int numComidas = Utilidades.leerNumero();
        
        HashSet<comida> comidas = new HashSet<comida>();
        for(int i = 0; i < numComidas; i++){
            Utilidades.mostrarPorPantalla("Ingrese el tipo de la comida n°" + i + ": ");
            String tipo = Utilidades.leerTexto();
            Utilidades.mostrarPorPantalla("Ingrese el nombre de la comida n°" + i + ": ");
            String nombre = Utilidades.leerTexto();
            comidas.add(new comida(tipo,nombre));
        }
        
        reserva r = new reserva(reservas, Fecha, Horario, Localidad, Precio);
        
        if(!comidas.isEmpty()){
            Iterator iter = comidas.iterator();
            while (iter.hasNext()) {
                r.agregarComida((comida)iter.next());
            }
        }

        reservas.agregarReserva(r);

    }
}

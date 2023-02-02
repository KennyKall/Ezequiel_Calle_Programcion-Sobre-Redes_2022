/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author agust
 */
public class BaseDeDatos implements Serializable {

    private static final long serialVersionUID = -1000L;

    private List<Cliente> bUsuario;
    private List<reserva> bReserva;

    public BaseDeDatos() {
        bUsuario = new LinkedList<>();
        bReserva = new LinkedList<>();
    }

    /*Métodos base de usuarios*/
    public void agregarUsuario(Cliente c) {
        if (c != null) {
            bUsuario.add(c);
        }
    }

    public Cliente devolverUsuario(int i) {
        Cliente aux = bUsuario.get(i);
        return aux;
    }
    
    public void actualizarUsuario(int i, Cliente registro){
        Cliente c = bUsuario.get(i);
        
        c.setApellido(registro.getApellido());
        c.setNombre(registro.getNombre());
        c.setNumContacto(registro.getNumContacto());
        c.setUsuarios(registro.getUsuarios());
    }
    
    public void borrarCliente(int i){
        if((i > 0) && (i < bUsuario.size())){
            bUsuario.remove(i);
        }else{
            Utilidades.mostrarPorPantalla("Número no válido");
        }
    }

    public void mostrarClientes() {
        int x = 1;
        for (Cliente c : bUsuario.subList(1, bUsuario.size())) {
            Utilidades.mostrarPorPantalla("Cliente N°" + x);
            c.mostrarDatos();
            x++;
        }
    }

    /*Métodos base de reservas*/
    public void agregarReserva(reserva r) {
        if (r != null) {
            bReserva.add(r);
        }
    }

    public reserva devolverReserva(int i) {
        reserva aux = bReserva.get(i);
        return aux;
    }
    
    public void actualizarReserva(int i, reserva registro){
        reserva c = bReserva.get(i);
        
        c.setFecha(registro.getFecha());
        c.setHorario(registro.getHorario());
        c.setLocalidad(registro.getLocalidad());
        c.setPrecio(registro.getPrecio());
        
    }
    
    public void borrarReserva(int i){
        if((i > 0) && (i < bReserva.size())){
            bReserva.remove(i);
        }else{
            Utilidades.mostrarPorPantalla("Número no válido");
        }
    }

    public void mostrarReservas() {
        int x = 1;
        for (reserva r : bReserva.subList(1, bReserva.size())) {
            Utilidades.mostrarPorPantalla("Reserva N°" + x);
            r.mostrarDatos();
            x++;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC ARI Central
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

    public List<Cliente> getbUsuario() {
        return bUsuario;
    }

    public void setbUsuario(List<Cliente> bUsuario) {
        this.bUsuario = bUsuario;
    }

    public List<reserva> getbReserva() {
        return bReserva;
    }

    public void setbReserva(List<reserva> bReserva) {
        this.bReserva = bReserva;
    }
    
    
    
    /**
     * devuelve un usuario dado un objeto Cliente. Devuelve null si no existe
     * @param cDevolver
     * @return 
     */
    public Cliente devolverUsuario(Cliente cDevolver) {
        Cliente aux = null;
        for (Cliente c : bUsuario.subList(1, bUsuario.size())) {
            if(c.equals(cDevolver)){
                aux = c;
            }
        }
        return aux;
    }
    
    public void actualizarUsuario(Cliente registro){
        for (Cliente c : bUsuario.subList(1, bUsuario.size())) {
            if(c.getDni() == registro.getDni()){
                c.setApellido(registro.getApellido());
                c.setNombre(registro.getNombre());
                c.setNumContacto(registro.getNumContacto());
                c.setUsuarios(registro.getUsuarios());
            }
        }
    }
    
    public void borrarCliente(Cliente cBorrar){
        for (Cliente c : bUsuario.subList(1, bUsuario.size())) {
            if(c.equals(cBorrar)){
                bUsuario.remove(c);
            }
        }
    }
    
    public LinkedList<Cliente> devolverClientes() {
        LinkedList<Cliente> bdd = new LinkedList<Cliente>();
        for (Cliente c : bUsuario.subList(1, bUsuario.size())) {
            bdd.add(c);
        }
        return bdd;
    }

    public void mostrarClientes() {
        for (Cliente c : bUsuario.subList(1, bUsuario.size())) {
            c.mostrarDatos();
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
    
    public void borrarReserva(reserva rBorrar){
        for (reserva r : bReserva.subList(1, bReserva.size())) {
            if(r.equals(rBorrar)){
                bReserva.remove(r);
            }
        }
    }

    public void mostrarReservas() {
        for (reserva r : bReserva.subList(1, bReserva.size())) {
            r.mostrarDatos();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author agust
 */
public class Cliente extends Persona implements GeneralDTO{
    private BaseDeDatos usuarios;

    public Cliente(BaseDeDatos lista, int dni, String nombre, String apellido, String numContacto) {
        super(dni, nombre, apellido, numContacto);
        this.usuarios = lista;
    }
    
    public Cliente(int dni, String nombre, String apellido, String numContacto) {
        super(dni, nombre, apellido, numContacto);
    }
    

    public BaseDeDatos getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(BaseDeDatos usuarios) {
        this.usuarios = usuarios;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }
    
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                Utilidades.mostrarPorPantalla(
                        "\tMENÚ CLIENTES\n\n"
                        + "\t[1] Cargar un Cliente\n"
                        + "\t[2] Mostrar Clientes\n"
                        + "\t[3] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '1':
                    this.cargarNuevoCliente();
                    break;
                case '2':
                    usuarios.mostrarClientes();
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }
    
    
    @Override
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("CLIENTE: \n"
                + "\t Nombre: " + this.nombre + "\n"
                + "\t Apellido: " + this.apellido + "\n"
                + "\t Telefono: " + this.numContacto + "\n"
                + "==================================\n"
        );
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.usuarios);
        hash = 59 * hash + Objects.hashCode(this.apellido);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.dni);
        hash = 59 * hash + Objects.hashCode(this.numContacto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.numContacto, other.numContacto)) {
            return false;
        }
        if (!Objects.equals(this.usuarios, other.usuarios)) {
            return false;
        }
        return true;
    }
    
    public void cargarNuevoCliente() {

        Utilidades.mostrarPorPantalla("Ingrese el DNI: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String telefono = Utilidades.leerTexto();
        
        Cliente c = new Cliente(usuarios, dni,nombre,apellido,telefono);

        usuarios.agregarUsuario(c);

    }
    
    
}

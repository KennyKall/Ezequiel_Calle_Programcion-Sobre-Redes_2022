/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author agust
 */
public class Cliente extends Persona{
    private BaseDeDatos usuarios;

    public Cliente(BaseDeDatos lista, int dni, String nombre, String apellido, String numContacto) {
        super(dni, nombre, apellido, numContacto);
        this.usuarios = lista;
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
                        + "\t[2] Actualizar un Cliente\n"
                        + "\t[3] Borrar un Cliente\n"
                        + "\t[4] Mostrar Clientes\n"
                        + "\t[5] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                    this.cargarNuevoCliente();
                    break;
                case '2':
                    this.actualizarCliente();
                    break;
                case '3':
                    this.borrarCliente();
                    break;
                case '4':
                    usuarios.mostrarClientes();                
                    break;
                case '5':
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
    
    public void actualizarCliente() {

        usuarios.mostrarClientes();
        
        Utilidades.mostrarPorPantalla("Ingrese el número de cliente a modificar: ");
        int id = Utilidades.leerNumero();
        
        Utilidades.mostrarPorPantalla("Ingrese el DNI: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String telefono = Utilidades.leerTexto();
        
        Cliente c = new Cliente(usuarios, dni,nombre,apellido,telefono);

        usuarios.actualizarUsuario(id, c);

    }
    
    public void borrarCliente() {

        usuarios.mostrarClientes();
        
        Utilidades.mostrarPorPantalla("Ingrese el número de cliente a eliminar: ");
        int id = Utilidades.leerNumero();

        usuarios.borrarCliente(id);

    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_2.pkg1_binario;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Agust
 * 
 */
public abstract class Persona implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1000L;
    
    protected int dni;
    protected String nombre;
    protected String apellido;
    protected String numContacto;    

    public Persona(int dni, String nombre, String apellido, String numContacto) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numContacto = numContacto;
    }

    public abstract void mostrarDatos();
    
    public abstract boolean mostrarMenu();
    
}

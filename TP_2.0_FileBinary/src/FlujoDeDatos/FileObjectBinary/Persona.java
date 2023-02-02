/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import java.io.Serializable;
import java.util.Date;

/**
 * En esta class aplicamos patron de diseño FACTORY
 * @author Software-Notebook
 * 
 */
public abstract class Persona implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1000L;
    
    protected int DNI;
    protected Date fechaDeIngreso;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected int edad;
    protected Genero genero;
    protected String numContacto; //despues usamos Format para pasarlo a Int      

    /**
     * 
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto 
     */
    public Persona(int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        this.DNI = DNI;
        this.fechaDeIngreso = fechaDeIngreso;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.genero = genero;
        this.numContacto = numContacto;
    }
    
    /**
     * Distintas acciones dependiendo que tiepo de persona sea
     */
    public abstract void proceder();

    public abstract void mostrarDatos();
    
    public abstract boolean mostrarMenu();
    
    public abstract void calcular();
    
}

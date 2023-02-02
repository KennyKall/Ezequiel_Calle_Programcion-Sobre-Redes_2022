/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author PC ARI Central
 */
public class BaseDeUsuario implements Serializable {

    private static final long serialVersionUID = -1000L;

    private List<Persona> bUsuario;

    public BaseDeUsuario() {
        bUsuario = new LinkedList<>();
    }

    /**
     * Agrega un usuario a la lista bUsuario
     * @param p objeto persona a agregar
     */
    public void agregarUsuario(Persona p) {
        if (p != null) {
            bUsuario.add(p);
        }
    }

    /**
     * Retorna una persona de la lista bUsuario
     * @param i número de usuario en la lista
     * @return objeto persona
     */
    public Persona devolverUsurio(int i) {
        Persona auxP = bUsuario.get(i);
        return auxP;
    }

    //COMPLETAR USTEDES
    //
    // el metodo mostrar empleados modificarlo para que 
    // no este repetido y sea Orientado a Objetos y Abstracto
    // si es necesario.
    // realizar todas las documetaciones de JavaDoc de todo el proyecto.
    //
    //COMPLETAR USTEDES
    
    //COMPLETADO
    
    /**
     * Imprime por consola las personas de SOLO una clase en específico
     * @param c clase a imprimir (ejemplo: clase socio, clase empleado)
     */
    public void mostrarPersonas(Class<?> c) {
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if (p.getClass() == c.asSubclass(c)) {
                p.mostrarDatos();
            }
        }
    }
    
    /**
     * Muestra las partidas de cada socio por consola
     */
    public void mostrarPartidasSocios(){
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if (p.getClass() == Socio.class) {
                Utilidades.mostrarPorPantalla("----------Socio " + p.nombre + " " + p.apellido + "----------");
                ((Socio) p).mostrarPartidas();
                Utilidades.mostrarPorPantalla("");
            }
        }
    }

    /**
     * Actualiza los sueldos de todos los empleados ejecutando el método 'calcular' de cada uno
     */
    public void actualizarSueldosCoutas() {
        for (Persona p : bUsuario) {
            if (p instanceof Empleado) {
                ((Empleado) p).calcular();
            }
        }
    }
    
    /**
     * Muestra personas de una clase a la vez que devuelve la cantidad de estas
     * @param c clase (ejemplo: clase socio, clase empleado)
     * @return cantidad de personas de la clase colocada como parámetro
     */
    public int mostrarNombresPersonas(Class<?> c){
        int cant = 0;
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if(p.getClass() == c.asSubclass(c)){
                Utilidades.mostrarPorPantalla("[" + (cant + 1) + "] " + p.nombre + " " + p.apellido + "\n");
                cant++;
            }
        }
        return cant;
    }
    
    /**
     * Permite elegir un usuario de SOLO una clase en específico. Muestra todos los
     * usuarios de esa clase y luego solicita uno de ellos y lo devuelve
     * @param c clase (ejemplo: clase socio, clase empleado)
     * @return objeto persona
     */
    public Object elegirUsuario(Class<?> c) {
        
        int cant = mostrarNombresPersonas(c);
        
        Utilidades.mostrarPorPantalla("Elegir persona: ");
        
        int nUsuario = Utilidades.leerNumero();
        
        int i = 1;
        for (Persona p : bUsuario.subList(2, bUsuario.size())) {
            if(p.getClass() == c.asSubclass(c)){
                if(nUsuario == i){
                    return p;
                }else{
                    i++;
                }
            }
        }
        return null;
    }

}

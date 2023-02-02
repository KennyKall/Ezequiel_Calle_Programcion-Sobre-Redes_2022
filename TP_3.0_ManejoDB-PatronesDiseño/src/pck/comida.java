/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.Serializable;

/**
 *
 * @author agust
 */
public class comida implements Serializable{
    private String tipo;
    private String nombreComida;

    public comida(String tipo, String nombreComida) {
        this.tipo = tipo;
        this.nombreComida = nombreComida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }
    
    public void mostrarDatos(){
        Utilidades.mostrarPorPantalla("\t\tCOMIDA: \n"
                + "\t\t - Tipo: " + this.tipo + "\n"
                + "\t\t - Comida: " + this.nombreComida
        );
    }
}

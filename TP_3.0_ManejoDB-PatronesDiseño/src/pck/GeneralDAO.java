/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.util.ArrayList;

/**
 * El operador DIAMANTE nos permite avisarle a una class, metodo o interface
 * que va a utilizar un tipo de dato dinamico o GENERICO para trabajar en la 
 * declaracion, Luego en la implementacion se le modifica para que cada class
 * que la implementa pueda utilizar un tipo de datos diferente.
 * 
 * @author conso
 */
public interface GeneralDAO<T> {
    
    public void agregar( T registro);
    public void borrar( T registro);
    public void actualizar( T registro );
    public ArrayList<T> obtenerTodo();
    public T obtener( int id );
    
}

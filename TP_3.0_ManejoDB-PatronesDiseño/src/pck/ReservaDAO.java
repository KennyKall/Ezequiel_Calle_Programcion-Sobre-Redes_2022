/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En las Class con patron de diseño DAO vamos a implemetar la capa de negocios
 * especifica (la logica) para cada tabla de datos (o DTO) en este caso lo
 * aplicamos con el CRUD de cada tabla en particular.
 *
 * @author conso
 */
public class ReservaDAO implements GeneralDAO<reserva>{

    @Override
    public void agregar( reserva registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "INSERT INTO reserva(fecha,horario,localidad,precio) VALUES (?,?,?,?)";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setDate(1, registro.getFecha() );
            ps.setString(2, registro.getHorario());
            ps.setString(3, registro.getLocalidad());
            ps.setInt(4, registro.getPrecio());
            
            ps.executeUpdate();
            /**
             * Esto es una API que implementa una tecnica llama REFLEXION que
             * nos permite a grandes rasgos obtener datos de lo declarado en una
             * de nuestras Class mediente metados, en este caso lo usaremos para
             * saber los campos que sean necesarios para la consulta. Field[]
             * atributos = GeneralDAO.class.getDeclaredFields();
             */            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
    }

    @Override
    public void borrar( reserva registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "DELETE FROM reserva WHERE idReserva = ? ";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setInt(1, registro.getId() );
            
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }    
    }

    @Override
    public void actualizar( reserva registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "UPDATE reserva SET fecha=?, horario=?, localidad=?, precio=? where idReserva = ?";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setDate(1, registro.getFecha()); 
            ps.setString(2, registro.getHorario() );
            ps.setString(3, registro.getLocalidad() ); 
            ps.setInt(4, registro.getPrecio() );
            ps.setInt(5, registro.getId() ); 
            
            ps.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public ArrayList<reserva> obtenerTodo() {      
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<reserva> listAux = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM reserva";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement( sql );
            
            rs = ps.executeQuery();
            
            while( rs.next() )
            {             
                listAux.add( (reserva)DTOFactory.getInstance().getDTO("reserva", rs) );
            }
            
        }catch(SQLException ex){
            
        }finally{
            try {
            if( rs != null)
                rs.close();
                    
            if( ps != null )
                ps.close();
            
            if( con != null)
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        return listAux;
    }

    @Override
    public reserva obtener(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM reserva WHERE idReserva = ?";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement( sql );
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while( rs.next() )
            {             
                return (reserva)DTOFactory.getInstance().getDTO( "reserva" , rs ) ;
            }   
        }catch(SQLException ex){
            
        }finally{
            try {
            if( rs != null)
                rs.close();
                    
            if( ps != null )
                ps.close();
            
            if( con != null)
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        return null;   
    }
    
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                Utilidades.mostrarPorPantalla(
                        "\tMENÚ RESERVAS\n\n"
                        + "\t[1] Cargar una reserva\n"
                        + "\t[2] Actualizar una Reserva\n"
                        + "\t[3] Borrar una Reserva\n"
                        + "\t[4] Mostrar Reservas\n"
                        + "\t[5] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                    this.cargarNuevaReserva();
                    break;
                case '2':
                    this.actualizarReserva();
                    break;
                case '3':
                    this.borrarReserva();
                    break;
                case '4':
                    for (reserva a : obtenerTodo()) {
                        a.mostrarDatos();
                    }
                    //reservas.mostrarReservas();
                    break;
                case '5':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }
    
    public void cargarNuevaReserva() {

        Utilidades.mostrarPorPantalla("Ingrese el año del evento: ");
        int anio = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el mes del evento: ");
        int mes = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el dia del evento: ");
        int dia = Utilidades.leerNumero();
        Date Fecha = new Date(anio,mes,dia);
        
        Utilidades.mostrarPorPantalla("Ingrese el horario(mediodia/tarde/noche): ");
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
        
        reserva r = new reserva(1, Fecha, Horario, Localidad, Precio);
        
        if(!comidas.isEmpty()){
            Iterator iter = comidas.iterator();
            while (iter.hasNext()) {
                r.agregarComida((comida)iter.next());
            }
        }

        this.agregar(r);
        //reservas.agregarReserva(r);

    }
    
    public void actualizarReserva(){
        //reservas.mostrarReservas();
        int x = 1;
        for (reserva a : obtenerTodo()) {
            Utilidades.mostrarPorPantalla("Reserva N°"+x);
            a.mostrarDatos();
            x++;
        }
        
        Utilidades.mostrarPorPantalla("Ingrese el id del evento a modificar: ");
        int id = Utilidades.leerNumero();
        
        Utilidades.mostrarPorPantalla("Ingrese el año del evento: ");
        int anio = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el mes del evento: ");
        int mes = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el dia del evento: ");
        int dia = Utilidades.leerNumero();
        Date Fecha = new Date(anio,mes,dia);
        
        Utilidades.mostrarPorPantalla("Ingrese el horario (mediodia/tarde/noche): ");
        String Horario = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese la localidad: ");
        String Localidad = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el precio: ");
        int Precio = Utilidades.leerNumero();
        
        reserva r = new reserva(id, Fecha, Horario, Localidad, Precio);
        
        actualizar(r);
        
        //reservas.actualizarReserva(id, r);
        
    }
    
    public void borrarReserva(){
        //reservas.mostrarReservas();
        int x = 1;
        for (reserva a : obtenerTodo()) {
            Utilidades.mostrarPorPantalla("Reserva N°"+x);
            a.mostrarDatos();
            x++;
        }
        
        Utilidades.mostrarPorPantalla("Ingrese el ID del evento a eliminar: ");
        int id = Utilidades.leerNumero();
        
        for (reserva a : obtenerTodo()) {
            if(a.getId() == id){
                borrar(a);
            }
        }
        //reservas.borrarReserva(id);
    }
     
}

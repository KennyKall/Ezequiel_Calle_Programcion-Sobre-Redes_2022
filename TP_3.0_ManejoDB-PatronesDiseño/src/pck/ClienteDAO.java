/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ClienteDAO implements GeneralDAO<Cliente>{

    @Override
    public void agregar( Cliente registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "INSERT INTO cliente(dni,nombre,apellido,telefono) VALUES (?,?,?,?)";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setInt(1, registro.getDni() );
            ps.setString(2, registro.getNombre());
            ps.setString(3, registro.getApellido());
            ps.setString(4, registro.getNumContacto());
            
            ps.executeUpdate();
            /**
             * Esto es una API que implementa una tecnica llama REFLEXION que
             * nos permite a grandes rasgos obtener datos de lo declarado en una
             * de nuestras Class mediente metados, en este caso lo usaremos para
             * saber los campos que sean necesarios para la consulta. Field[]
             * atributos = GeneralDAO.class.getDeclaredFields();
             */            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
    }

    @Override
    public void borrar( Cliente registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "DELETE FROM cliente WHERE dni = ? ";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setInt(1, registro.getDni() );
            
            ps.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }              
    }

    @Override
    public void actualizar( Cliente registro) {
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            String consulta = "UPDATE cliente SET nombre=? , apellido=?, telefono=? WHERE dni=?";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement(consulta); 
            
            ps.setString(1, registro.getNombre() );
            ps.setString(2, registro.getApellido() );
            ps.setString(3, registro.getNumContacto() );
            ps.setInt(4, registro.getDni());
            
            System.out.println(ps);
            System.out.println(ps.toString());
            
            ps.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }

    @Override
    public ArrayList<Cliente> obtenerTodo() {      
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cliente> listAux = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM cliente";
            
            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement( sql );
            
            rs = ps.executeQuery();
            
            while( rs.next() )
            {             
                listAux.add( (Cliente)DTOFactory.getInstance().getDTO("cliente", rs) );
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
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        return listAux;
    }

    @Override
    public Cliente obtener(int dni) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String sql = "SELECT * FROM cliente WHERE dni=?";

            con = ConexionesFactory.getInstance().getConection();
            ps = con.prepareStatement( sql );

            ps.setInt(1, dni);

            rs = ps.executeQuery();

        while( rs.next() )
        {
            return (Cliente)DTOFactory.getInstance().getDTO( "cliente" , rs ) ;
        }
        }catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        try {
            if( rs != null)
                rs.close();

            if( ps != null )
                ps.close();

            if( con != null)
                con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    for (Cliente a : obtenerTodo()) {
                        a.mostrarDatos();
                    }        
                    //usuarios.mostrarClientes();                
                    break;
                case '5':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
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
        
        Cliente c = new Cliente(dni,nombre,apellido,telefono);

        this.agregar(c);
        //usuarios.agregarUsuario(c);

    }
    
    public void actualizarCliente() {

        //usuarios.mostrarClientes();
        int x = 1;
        for (Cliente a : obtenerTodo()) {
            Utilidades.mostrarPorPantalla("Cliente N°"+x);
            a.mostrarDatos();
            x++;
        }
        
        Utilidades.mostrarPorPantalla("Ingrese el DNI del cliente a modificar: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String telefono = Utilidades.leerTexto();
        
        Cliente c = new Cliente(dni,nombre,apellido,telefono);
        
        actualizar(c);
        
        //usuarios.actualizarUsuario(id, c);

    }
    
    public void borrarCliente() {

        //usuarios.mostrarClientes();
        int x = 1;
        for (Cliente a : obtenerTodo()) {
            Utilidades.mostrarPorPantalla("Cliente N°"+x);
            a.mostrarDatos();
            x++;
        }
        
        Utilidades.mostrarPorPantalla("Ingrese el número de cliente a eliminar: ");
        int id = Utilidades.leerNumero();
        
        int i = 1;
        for (Cliente a : obtenerTodo()) {
            if (i == id){
                borrar(a);
            }
            i++;
        }

        //usuarios.borrarCliente(id);

    }
     
}

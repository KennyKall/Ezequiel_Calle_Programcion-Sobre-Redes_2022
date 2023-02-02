/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase trabaja creando insancias de si misma se forma statica para
 * asegurarse se que solo exista una instancia de de conexion, mientras la
 * instancia este se utilizara para conectarnos, si no se encuentra creara una
 * nueva a pedido este sistema de "crear objetos a pedido" se conoce como patron
 * FACTORY.
 *
 * @author conso
 */
public class ConexionesFactory {

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/tp_pizzaparty";
    String user = "root";
    String pass = "";

    /**
     * No es extrictamente necesario que lleve el static de si mismo esto es una
     * mescla con otro patron de sideño llama SINGLENTON que permite crear
     * intancias de objetos que sean unicas para no tener miles de instancias
     * sin uso, se complementa bien con FACTORY.
     */
    private static ConexionesFactory fabrica = null;

    /**
     * El constructor tiene la peculiaridad de ser PRIVADO en el ambos patrones.
     */
    private ConexionesFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionesFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConection() throws SQLException {
        Connection conn = null;
        
        conn = DriverManager.getConnection(url, user, pass);
        
        return conn;
    }

    /**
     * Aca bemos el claro funcionamiento del FACTORY, donde un metodo instancia
     * un objeto de si mismo, para luego devolver tantas instancias de como sean
     * pedidas, de alguna class en especial (o multiples clases con la misma
     * interface)
     *
     * Ademas podemos conectarnos a distintas DB pidiendo diferentes conexiones.
     *
     * @return
     */
    //public synchronized static ConnectionFactory getInstance() {    
    public static ConexionesFactory getInstance() {
        if (fabrica == null) {
            fabrica = new ConexionesFactory();
        }

        return fabrica;
    }

}

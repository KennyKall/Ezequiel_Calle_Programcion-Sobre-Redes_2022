/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;


/**
 *
 * @author Redes05
 */
public class Sistemita implements Serializable{
    private static final long serialVersionUID = -1000L;
    private BaseDeDatos bdd;
        
    public Sistemita() {
        bdd = new BaseDeDatos();
    }
    
    public Sistemita deSerializar(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(archivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Sistemita s = (Sistemita) ois.readObject();
        ois.close();
        fis.close();
        File a = new File(archivo);
        a.delete();
        
        return s;
    }
    
    public void cargaBDD(){
        
        ReservaDAO lDAO = new ReservaDAO();
        for (reserva a : bdd.getbReserva()){
            reserva l = (reserva) a;
            lDAO.agregar(l);
        };
        
        ClienteDAO cDAO = new ClienteDAO();
        for (Cliente a : bdd.getbUsuario()){
            Cliente l = (Cliente) a;
            cDAO.agregar(l);
        };
    }

    public void creacion() {
        bdd.agregarReserva(new reserva(1,new Date(2020,2,2),"mediodia","localidad",111));
        bdd.agregarUsuario(new Cliente(45219222, "aaafff", "aadfafdsa", "43342323"));
        bdd.agregarReserva(new reserva(2,new Date(2020,2,2),"mediodia","localidad",111));
        bdd.agregarUsuario(new Cliente(45219222, "afff", "aadfafdsa", "43342323"));
        bdd.agregarReserva(new reserva(3,new Date(2020,2,2),"mediodia","localidad",111));
        bdd.agregarUsuario(new Cliente(45219222, "nfff", "aadfafdsa", "43342323"));
        
    }

    public void serializar(String archivo) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this);
        oos.close();
    }

    
    public void prender() {
        
        boolean corriendo = true;
        
        while( corriendo )
        {
            corriendo = mostrarMenu();    
        }
        Utilidades.mostrarPorPantalla("GRACIAS POR USAR MI PROGRAMA.");
              
    }


    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                Utilidades.mostrarPorPantalla(
                        "MENÚ PRINCIPAL\n\n"
                        + "[1] Menu de Clientes\n"
                        + "[2] Menu de Reservas\n"
                        + "[3] Salir\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '3');

            switch (op) {
                case '1':
                    ClienteDAO cDAO = new ClienteDAO();
                    continuar = cDAO.mostrarMenu();
                    //continuar = usuarios.devolverUsuario(0).mostrarMenu() ;
                    break;
                case '2':
                    ReservaDAO rDAO = new ReservaDAO();
                    continuar = rDAO.mostrarMenu();
                    //continuar = usuarios.devolverReserva(0).mostrarMenu() ;
                    break;
                case '3':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }     
}

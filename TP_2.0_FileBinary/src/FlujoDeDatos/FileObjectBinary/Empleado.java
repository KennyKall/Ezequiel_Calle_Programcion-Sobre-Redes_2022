/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlujoDeDatos.FileObjectBinary;

import java.util.Date;
import static FlujoDeDatos.FileObjectBinary.Utilidades.mostrarPorPantalla;

/**
 *
 * @author Software-Notebook
 */
public class Empleado extends Persona {

    private int codigo;
    private Puestos puesto;
    private float sueldo;
    private BaseDeUsuario usuarios;

    /**
     *
     * @param codigo
     * @param puesto
     * @param sueldo
     * @param DNI
     * @param fechaDeIngreso
     * @param nombre
     * @param apellido
     * @param direccion
     * @param edad
     * @param genero
     * @param numContacto
     */
    public Empleado(BaseDeUsuario lista, int codigo, Puestos puesto, int DNI, Date fechaDeIngreso, String nombre, String apellido, String direccion, int edad, Genero genero, String numContacto) {
        super(DNI, fechaDeIngreso, nombre, apellido, direccion, edad, genero, numContacto);

        this.codigo = codigo;
        this.puesto = puesto;
        this.sueldo = -1;
        this.usuarios = lista;
    }

    /**
     * Modifica el valor de la cuota dependiendo de la antiguedad y el puesto del empleado
     */
    @Override
    public void calcular() {
        //COMPLETAR USTEDES
        //
        // cambia segun la antiguedad
        // 2 - 5% | 10 - 10% | 15 - 20% | >15 - 30%
        //
        //COMPLETAR USTEDES
        
        //COMPLETADO
              
        switch (this.puesto) {
            case Administrativo:
                this.sueldo = 50000;
                break;
            case Caddy:
                this.sueldo = 30000;
                break;
            case Gerente:
                this.sueldo = 100000;
                break;
            case Limpieza:
                this.sueldo = 40000;
                break;
            case RecogedorDePelotas:
                this.sueldo = 5000;
                break;
        }
        
        long añoActual = new Date(System.currentTimeMillis()).getYear() + 1900;
        int antiguedad = (int) añoActual - this.fechaDeIngreso.getYear();
        
        if (antiguedad < 2){
            this.sueldo += this.sueldo * 0.05;
        }else if(antiguedad < 10){
            this.sueldo += this.sueldo * 0.1;
        }else if(antiguedad < 15){
            this.sueldo += this.sueldo * 0.2;
        }else if(antiguedad > 15){
            this.sueldo += this.sueldo * 0.3;
        }
    }

    /**
     * muestra el menú de empleados, solicita una opción y la procesa.
     * @return variable continuar que determina que finalizo la ejecución del menú empleados
     */
    @Override
    public boolean mostrarMenu() {
        boolean cerrar = false, continuar = true;
        while (!cerrar) {
            char op;
            do {
                //COMPLETAR USTEDES
                //
                // agregar opcion para cambiar de puesto.
                //verificar que que no explote las cargas de datos nuevos
                // ni los pedidos de mostrar datos far falta de ellos.
                //
                //COMPLETAR USTEDES
                mostrarPorPantalla(
                        "\tMENÚ EMPLEADO\n\n"
                        + "\t[1] Cargar un Empleado\n"
                        + "\t[2] Calcular Sueldos\n"
                        + "\t[3] Mostrar Empleados\n"
                        + "\t[4] Cambiar de puesto\n"
                        + "\t[5] Volver\n"
                );
                op = Utilidades.obtenerOpcion();
            } while (op < '1' || op > '5');

            switch (op) {
                case '1':
                    this.cargarNuevoEmpleado();
                    break;
                case '2':
                    usuarios.actualizarSueldosCoutas();
                    break;
                case '3':
                    usuarios.mostrarPersonas(Empleado.class);
                    break;
                case '4':
                    this.cambiarPuesto((Empleado) usuarios.elegirUsuario(Empleado.class));
                    break;
                case '5':
                    cerrar = true;
                    continuar = false;
                    break;
            }
        }
        return continuar;
    }

    /**
     * Muestra por consola los datos del empleado
     */
    @Override
    public void mostrarDatos() {
        Utilidades.mostrarPorPantalla("EMPLEADO: \n"
                + "\t NOMBRE: " + this.nombre + "\n"
                + "\t APELLIDO: " + this.apellido + "\n"
                + "\t DIRECCION: " + this.direccion + "\n"
                + "\t GENERO: " + this.genero + "\n"
                + "\t TEL: " + this.numContacto + "\n"
                + "\t DNI: " + this.DNI + "\n"
                + "----------------------\n"
                + "\t CODIGO: " + this.codigo + "\n"
                + "\t PUESTO: " + this.puesto + "\n"
                + "\t SUELDO: " + this.sueldo + "\n"
                + "==================================\n"
        );
    }

    /**
     * Muestra el menú de empleado
     */
    @Override
    public void proceder() {
        mostrarMenu();
    }

    /**
     * Solicita los datos de un nuevo empleado, crea un objeto con los mismos y lo agrega a la base de usuarios
     */
    public void cargarNuevoEmpleado() {

        //aca deberiamos hacer un Do While para verificar si ingreso datos el usuario 
        Utilidades.mostrarPorPantalla("Ingrese el codigo: ");
        int cod = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el puesto: ");
        Puestos pue = Utilidades.elegirPuesto();
        Utilidades.mostrarPorPantalla("Ingrese el dni: ");
        int dni = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Fecha de Ingreso: ");
        Date fecha = Utilidades.leerFecha();
        Utilidades.mostrarPorPantalla("Ingrese el Nombre: ");
        String nombre = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Apellido: ");
        String apellido = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Direcion: ");
        String direccion = Utilidades.leerTexto();
        Utilidades.mostrarPorPantalla("Ingrese el Edad: ");
        int edad = Utilidades.leerNumero();
        Utilidades.mostrarPorPantalla("Ingrese el Genero: ");
        Genero gen = Utilidades.leerGenero();
        Utilidades.mostrarPorPantalla("Ingrese el Telefono: ");
        String tel = Utilidades.leerTexto();

        Empleado e = new Empleado(usuarios, cod, pue, dni, fecha, nombre, apellido, direccion, edad, gen, tel);

        usuarios.agregarUsuario(e);

    }
    
    /**
     * Solicita un nuevo puesto y modifica su atributo por el nuevo puesto
     * @param e objeto empleado
     */
    public void cambiarPuesto(Empleado e){
        
        Utilidades.mostrarPorPantalla("Ingrese el nuevo puesto: ");
        Puestos puest = Utilidades.elegirPuesto();
        
        e.puesto = puest;
        
    }

}

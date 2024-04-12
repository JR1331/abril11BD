package com.softtek.presentacion;

import com.softtek.modelo.Empleado;
import com.softtek.persistencia.AccesoEmpleado;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Que quieres hacer en la BBDD");
        System.out.println("1. Mostrar uno, 2.Mostrar todos, 3.Añadir, 4.Eliminar, 5.Modificar");
        Scanner sc = new Scanner(System.in);
        AccesoEmpleado ae = new AccesoEmpleado();
        int opt = sc.nextInt();
        int id;
        switch (opt){
            case 1:
                System.out.println("Has seleccionado mostrar un empleado");
                System.out.println("Indica cual es el id del empleado a buscar");
                System.out.println(ae.obtenerEmpleadoPorId(sc.nextInt()));
                break;
            case 2:
                System.out.println("Has seleccionado mostrar todos los empleado");
                System.out.println(ae.obtenerTodos());
                break;
            case 3:
                System.out.println("Has seleccionado añadir un nuevo empleado");
                Empleado e1 = new Empleado();
                System.out.println("Introduzca el id del empleado");
                e1.setIdEmpleado(sc.nextInt());
                System.out.println("Introduzca el nombre del empleado");
                e1.setNombre(sc.next());
                System.out.println("Introduzca el apellido del empleado");
                e1.setApellidos(sc.next());
                System.out.println("Introduzca el id del jefe del empleado");
                e1.setJefe(sc.nextInt());
                System.out.println(ae.añadir(e1));
                break;
            case 4:
                System.out.println("Has seleccionado añadir un nuevo empleado");
                System.out.println("Indica cual es el id del empleado a buscar");
                if(ae.borrarEmpleado(sc.nextInt())){
                    System.out.println("El empleado ha sido borrado correctamente");
                }else{
                    System.out.println("Ha ocurrido un error durante el borrado del empleado");
                }
                break;
            case 5:
                System.out.println("Has seleccionado modificar un empleado existente");
                System.out.println("Introduce el ID del empleado que deseas modificar:");
                int idEmpleadoModificar = sc.nextInt();
                System.out.println("Introduce el nuevo nombre del empleado:");
                String nuevoNombre = sc.next();
                System.out.println("Introduce el nuevo apellido del empleado:");
                String nuevoApellido = sc.next();
                System.out.println("Introduce el nuevo ID del jefe del empleado:");
                int nuevoIdJefe = sc.nextInt();
                try {
                    if (ae.modificarEmpleado(idEmpleadoModificar, new Empleado(idEmpleadoModificar, nuevoNombre, nuevoApellido, nuevoIdJefe))) {
                        System.out.println("Empleado modificado exitosamente.");
                    } else {
                        System.out.println("No se pudo modificar el empleado.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error al modificar el empleado: " + e.getMessage());
                }
                break;
            default:System.out.println("Opcion no valida");
        }

    }
}

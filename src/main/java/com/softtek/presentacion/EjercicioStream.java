package com.softtek.presentacion;

import com.softtek.modelo.Cliente;
import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoEmpleado;
import com.softtek.persistencia.AccesoProducto;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;

public class EjercicioStream {
    private void ej1(List<Producto> list, int categoria) {
        Predicate<Producto> cate2 = p -> p.getIdProducto()== categoria;

        list.stream()
                .filter(cate2)
                .forEach(System.out::println);
    }

    private void ej2(List<Producto> list){
        Predicate<Producto> empiezaN = p -> p.getNombreProducto().startsWith("N");
        list.stream()
                .filter(empiezaN)
                .forEach(System.out::println);
    }

    private void ej3(List<Producto> list){

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccesoEmpleado ae = new AccesoEmpleado();
        AccesoProducto ap = new AccesoProducto();
        EjercicioStream es = new EjercicioStream();
        es.ej1(ap.obtenerTodos(),2);
        es.ej2(ap.obtenerTodos());
    }
}

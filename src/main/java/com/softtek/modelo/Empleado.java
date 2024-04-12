package com.softtek.modelo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String Apellidos;
    private int jefe;
}

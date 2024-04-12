package com.softtek.modelo;


import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int discontinuado;
}
package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion{
    public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException{
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, discontinued from products;";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()){
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("discontinued")));
        }
        return productos;
    };

    public Producto obtenerUno(int id) throws ClassNotFoundException, SQLException{
        Statement sentencia;
        ResultSet resultado;
        String sql = "";
        sql = " Select product_id, product_name, unit_price, discontinued from products where product_id = "+id+" ;";
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if (resultado.next()){
            return new Producto((resultado.getInt("product_id")),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("discontinued"));
        }else{
            return null;
        }
    }

    public boolean añadir(Producto p) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO products (product_id, product_name, unit_price, discontinued)\n" +
                "\t\t\t\tVALUES (?, ?, ?, ?)";
        abrirConexion();
        PreparedStatement ps = miConexion.prepareStatement(sql);
        ps.setInt(1,p.getIdProducto());
        ps.setString(2,p.getNombreProducto());
        ps.setDouble(3,p.getPrecioUnitario());
        ps.setInt(4,p.getDiscontinuado());
        return ps.executeUpdate() > 0;
    }

    public boolean eliminar(int id) throws SQLException, ClassNotFoundException{

        String sql = "";
        sql = " Delete from products where product_id = "+id+" ;";
        abrirConexion();
        PreparedStatement ps = miConexion.prepareStatement(sql);
        return ps.executeUpdate() > 0;
    }

    public boolean modificar(int id) throws SQLException, ClassNotFoundException{
        String sql = "";
        sql = "Update products set product_name='updateado' where product_id= "+id+" ;";
        abrirConexion();
        PreparedStatement ps = miConexion.prepareStatement(sql);
        return ps.executeUpdate() > 0;
    }
}

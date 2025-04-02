package org.example.ninjas.model;

import java.sql.*;
import java.util.ArrayList;

public class ninjaDAO {
    static Connection conexion;
    static {
        try {
            conexion = org.example.clasesGenerales.conexion.con();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<ninja> viewNinja(int id) throws SQLException{
        String sql = "select * from ninja where id = ?";

        ArrayList<ninja> ninja = new ArrayList<>();

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            query.setInt(1,id);
            ResultSet ninjas = query.executeQuery();
            while (ninjas.next()){
                int idNinja = ninjas.getInt("id");
                String nombreNinja = ninjas.getString("nombre");
                String rango = ninjas.getString("rango");
                String aldea = ninjas.getString("aldea");

                ninja.add(new ninja(idNinja,nombreNinja,rango,aldea));
            }
        }
        return ninja;
    }
    public static ArrayList<habilidades> viewHabilidades(int id) throws SQLException{
        String sql = "select * from habilidad where id_ninja = ?";
        ArrayList<habilidades> habilidades = new ArrayList<>();
        try(PreparedStatement query = conexion.prepareStatement(sql)){
            query.setInt(1,id);
            ResultSet habilidadV = query.executeQuery();
            while (habilidadV.next()){
                int idHabilidad = habilidadV.getInt("idH");
                String nombreHabilidad = habilidadV.getString("nombreHabilidad");
                String descripcion = habilidadV.getString("descripcion");

                habilidades.add(new habilidades(idHabilidad,nombreHabilidad,descripcion));
            }
        }
        return habilidades;
    }
    public static ArrayList<ninja> viewAllNinja() throws SQLException{
        String sql = "select * from ninja";

        ArrayList<ninja> ninja = new ArrayList<>();

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            ResultSet ninjas = query.executeQuery();
            while (ninjas.next()){
                int idNinja = ninjas.getInt("id");
                String nombreNinja = ninjas.getString("nombre");
                String rango = ninjas.getString("rango");
                String aldea = ninjas.getString("aldea");

                ninja.add(new ninja(idNinja,nombreNinja,rango,aldea));
            }
        }
        return ninja;
    }
}

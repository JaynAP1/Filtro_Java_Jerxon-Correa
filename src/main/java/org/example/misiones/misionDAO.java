package org.example.misiones;

import java.sql.*;
import java.util.ArrayList;

public class misionDAO {
    static Connection conexion;
    static {
        try {
            conexion = org.example.clasesGenerales.conexion.con();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<misiones> viewMisiones() throws SQLException{
        String sql = "select * from mision where completada = 0";

        ArrayList<misiones> mision = new ArrayList<>();

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            ResultSet verMision = query.executeQuery();

            while (verMision.next()){
                int idMision = verMision.getInt("id");
                String descripcion = verMision.getString("descripcion");
                String rango = verMision.getString("rango");
                int recompensa = verMision.getInt("recompensa");

                mision.add(new misiones(idMision,descripcion,rango,recompensa));
            }
        }
        return mision;
    }

    public static ArrayList<misiones> viewCompletesNinjasMisiones(int id) throws SQLException {
        String sql = "select * from misionNinja inner join mision on misionNinja.id_mision = mision.id where id_ninja = ? and fecha_fin != '0'";
        ArrayList<misiones> misionCompleta = new ArrayList<>();

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            query.setInt(1,id);
            ResultSet verCompletas = query.executeQuery();

            while (verCompletas.next()){
                int idMision = verCompletas.getInt("id_mision");
                int idNinja = verCompletas.getInt("id_ninja");
                String descripcion = verCompletas.getString("descripcion");
                String fechaInicio = verCompletas.getString("fecha_inicio");
                String fechaFinal = verCompletas.getString("fecha_fin");

                misionCompleta.add(new misiones(idMision,idNinja,descripcion, fechaInicio,fechaFinal));
            }
        }
        return misionCompleta;
    }

    public static ArrayList<misiones> viewCompletesMisiones() throws SQLException{
        String sql = "select * from misionNinja inner join mision on misionNinja.id_mision = mision.id;";
        ArrayList<misiones> misionCompleta = new ArrayList<>();

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            ResultSet verCompletas = query.executeQuery();
            while (verCompletas.next()){
                int idMision = verCompletas.getInt("id_mision");
                int idNinja = verCompletas.getInt("id_ninja");
                String descripcion = verCompletas.getString("descripcion");
                String fechaInicio = verCompletas.getString("fecha_inicio");
                String fechaFinal = verCompletas.getString("fecha_fin");

                misionCompleta.add(new misiones(idMision,idNinja,descripcion, fechaInicio,fechaFinal));
            }
        }
        return misionCompleta;
    }

    public static void asignarMision(int idMision, int idNinja, String FechaInicio) throws SQLException{
        String sql = "insert into misionNinja(id_ninja, id_mision, fecha_inicio, fecha_fin) values(?,?,?,0)";

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            query.setInt(1,idNinja);
            query.setInt(2,idMision);
            query.setString(3,FechaInicio);
            query.executeUpdate();
            misionTrabajando(idMision);
        }

    }

    public static void misionTrabajando(int idMision) throws SQLException{
        String sql = "update mision set completada = 2 where id = ?";

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            query.setInt(1,idMision);
            query.executeUpdate();
        }
    }
    public static ArrayList<misiones> verMisionesCurso() throws SQLException{
        String sql = "select * from misionNinja inner join mision on misionNinja.id_mision = mision.id where fecha_fin = 0;";

        ArrayList<misiones> mision = new ArrayList<>();

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            ResultSet misionCurso = query.executeQuery();

            while (misionCurso.next()){
                int idMision = misionCurso.getInt("misionNinja.id");
                int idNinja = misionCurso.getInt("id_ninja");
                String descripcion = misionCurso.getString("descripcion");
                String fechaInicio = misionCurso.getString("fecha_inicio");
                String fechaFinal = misionCurso.getString("fecha_fin");

                mision.add(new misiones(idMision,idNinja,descripcion, fechaInicio,fechaFinal));
            }

        }
        return mision;
    }

    public static void misionCompletada(int idMision, String fechaFinal) throws SQLException{
        String sql = "update misionNinja set fecha_fin = ? where id = ?;";

        try(PreparedStatement query = conexion.prepareStatement(sql)){
            query.setString(1,fechaFinal);
            query.setInt(2,idMision);
            query.executeUpdate();
        }
    }


}

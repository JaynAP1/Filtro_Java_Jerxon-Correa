package org.example.clasesGenerales;
import java.sql.*;

public class conexion {
    static String URL = "jdbc:mysql://brwhnvouktlyex7hdtjy-mysql.services.clever-cloud.com/brwhnvouktlyex7hdtjy";
    static String USERNAME = "ujbumhn5nptjlke8";
    static String PASSWORD = "JzuaFtyveQVk0wfeFVkO";

    public static Connection con() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}

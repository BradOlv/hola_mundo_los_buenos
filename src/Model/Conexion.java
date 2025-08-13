package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conexion;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/DBconexionGuitarras?useSSL=false";
    private static final String user = "admin";
    private static final String password = "kinal123";
    private static final String driver = "com.mysql.jdbc.Driver";

    public Conexion() {
        conectar();
    }

    public void conectar() {
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(URL, user, password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | SQLException ex) {
            System.out.println("Error al conectar");
            ex.printStackTrace();
        }
    }

    public Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conexion;
    }
}
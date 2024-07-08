package mx.insoftec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    private final String URL = "jdbc:sqlserver://DELLSERVER\\SQLEXPRESS;databaseName=dbDXSAT";
    private final String PASS = "aspel**2022";
    private final String USERNAME = "sa";

    public void Conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(URL, USERNAME, PASS);
        } catch (ClassNotFoundException | SQLException e) {
        }

    }

    public void Cerrar() throws SQLException {
        try {
            if (conn != null) {
                if (conn.isClosed() == false) {
                    conn.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}

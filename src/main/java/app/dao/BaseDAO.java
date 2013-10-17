package app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDAO {

    protected void cerrarConexion(Connection con) throws RuntimeException {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.println("Error Cerrar Conexion: " + e);
        }
    }

    protected void cerrarResultSet(ResultSet rs) throws RuntimeException {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.err.println("Error Cerrar ResultSet: " + e);
        }
    }
        protected void cerrarStatement(PreparedStatement stmt)
            throws RuntimeException {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException se) {
            System.err.println("Error: cerrarStatement: " + se);
        }
    }


    protected void cerrarCallable(CallableStatement callstm) throws Exception {
        try {
            if (callstm != null) {
                callstm.close();
            }
        } catch (SQLException e) {
            System.err.println("Error Cerrar Statement: " + e);
        }
    }
}

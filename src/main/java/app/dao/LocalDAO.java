package app.dao;

import app.model.Local;

import app.zelper.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalDAO extends BaseDAO {

    public List<Local> list() throws DAOExcepcion {
        List<Local> lista = new ArrayList<Local>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = ConexionDB.obtenerConexion();
            String query = "SELECT *FROM local ORDER BY descripcion;";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Local item = new Local();
                item.setId(rs.getInt("id"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setDireccion(rs.getString("direccion"));
                item.setMaps(rs.getString("maps"));
                item.setTelefono(rs.getString("telefono"));
                item.setEstado(rs.getInt("estado"));
                lista.add(item);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);

        }
        return lista;
    }

    public Local get(Local local) throws DAOExcepcion {
        String query = "SELECT  *FROM local WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Local item = new Local();
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, local.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setDireccion(rs.getString("direccion"));
                item.setMaps(rs.getString("maps"));
                item.setTelefono(rs.getString("telefono"));
                item.setEstado(rs.getInt("estado"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);

        }

        return item;

    }
}

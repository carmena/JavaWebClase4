/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.model.Local;
import app.model.Socio;
import app.zelper.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SocioDAO extends BaseDAO{
 public List<Socio> list() throws DAOExcepcion {
        List<Socio> lista = new ArrayList<Socio>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            String query = "SELECT *FROM socio ORDER BY paterno;";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Socio item = new Socio();
                item.setId(rs.getInt("id"));
                item.setEmail(rs.getString("email"));
                item.setNombres(rs.getString("nombres"));
                item.setPaterno(rs.getString("paterno"));
                item.setMaterno(rs.getString("materno"));
                item.setCelular(rs.getInt("celular"));
                item.setSexo(rs.getInt("sexo"));
                item.setDireccion(rs.getString("direccion"));
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

    public Socio get(Socio socio) throws DAOExcepcion {
        String query = "SELECT  *FROM socio WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Socio item = new Socio();
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, socio.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setEmail(rs.getString("email"));
                item.setNombres(rs.getString("nombres"));
                item.setPaterno(rs.getString("paterno"));
                item.setMaterno(rs.getString("materno"));
                item.setCelular(rs.getInt("celular"));
                item.setSexo(rs.getInt("sexo"));
                item.setDireccion(rs.getString("direccion"));
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

    public Socio save(Socio socio) throws DAOExcepcion {
        String query = "INSERT INTO socio (email,nombres,paterno,materno,celular,sexo,direccion) VALUES  (?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, socio.getEmail());
            stmt.setString(2, socio.getNombres());
            stmt.setString(3, socio.getPaterno());
            stmt.setString(4, socio.getMaterno());
            stmt.setInt(5, socio.getCelular());
            stmt.setInt(6, socio.getSexo());
            stmt.setString(7, socio.getDireccion());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo Insertar");
            }
            int id = 0;
            query = "select last_insert_id()";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            socio.setId(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return socio;
    }

    public Local update(Local local) throws DAOExcepcion {
        String query = "UPDATE socio direccion=?,descripcion=?,estado=?,maps=?,telefono=? WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, local.getDireccion());
            stmt.setString(2, local.getDescripcion());
            stmt.setInt(3, local.getEstado());
            stmt.setString(4, local.getMaps());
            stmt.setString(5, local.getTelefono());
            stmt.setLong(6, local.getId());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo actualizar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }

        return local;
    }

    public void delete(Local local) throws DAOExcepcion {
        String query = "delete from local WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, local.getId());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo eliminar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }
    
}

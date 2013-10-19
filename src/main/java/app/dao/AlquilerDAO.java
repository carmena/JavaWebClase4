package app.dao;

import app.model.Alquiler;
import app.model.Campo;
import app.model.Local;
import app.model.Servicio;
import app.model.Socio;
import app.zelper.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAO extends BaseDAO {

    public List<Alquiler> list() throws DAOExcepcion {
        List<Alquiler> lista = new ArrayList<Alquiler>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            String query = "SELECT *FROM alquiler ORDER BY descripcion";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Alquiler item = new Alquiler();
                item.setId(rs.getInt("id"));
                item.setHoraInicio(rs.getString("hora_inicio"));
                item.setHoraFin(rs.getString("hora_fin"));
                item.setFecha(rs.getDate("fecha"));
                item.setEstado(rs.getInt("estado"));
                item.setServicios(rs.getString("servicios"));
                item.setSocio((Socio) rs.getObject("socio"));
                item.setCampo((Campo) rs.getObject("campo"));
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

    public Alquiler get(Alquiler alquiler)
            throws DAOExcepcion {
        String query = "SELECT *FROM alquiler WHERE id = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alquiler item = new Alquiler();
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, alquiler.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setHoraInicio(rs.getString("hora_inicio"));
                item.setHoraFin(rs.getString("hora_fin"));
                item.setFecha(rs.getDate("fecha"));
                item.setEstado(rs.getInt("estado"));
                item.setServicios(rs.getString("servicios"));
                item.setSocio((Socio) rs.getObject("socio"));
                item.setCampo((Campo) rs.getObject("campo"));

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

    public Alquiler save(Alquiler alquiler) throws DAOExcepcion {
        String query = "INSERT INTO alquiler(horaInicio,horaFin,fecha,servicios,estado,id_socio,id_campo) VALUES (?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);

            stmt.setString(1, alquiler.getHoraInicio());
            stmt.setString(2, alquiler.getHoraFin());
            stmt.setDate(3, (Date) alquiler.getFecha());
            stmt.setString(4, alquiler.getServicios());
            stmt.setInt(5, alquiler.getEstado());
            stmt.setObject(6, alquiler.getSocio());
            stmt.setObject(7, alquiler.getCampo());

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo insertar");
            }
            int id = 0;
            query = "select last_insert_id()";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            alquiler.setId(id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return alquiler;
    }

    public Alquiler update(Alquiler alquiler) throws DAOExcepcion {
        String query = "UPDATE alquiler horaInicio=?,horaFin=?,fecha=?,servicios=?,estado=?,socio=?,Campo=? WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, alquiler.getHoraInicio());
            stmt.setString(2, alquiler.getHoraFin());
            stmt.setDate(3, (Date) alquiler.getFecha());
            stmt.setString(4, alquiler.getServicios());
            stmt.setInt(5, alquiler.getEstado());
            stmt.setObject(6, alquiler.getSocio());
            stmt.setObject(6, alquiler.getCampo());

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo actualizar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return alquiler;
    }

    public void delete(Alquiler Alquiler) throws DAOExcepcion {
        String query = "DELETE FROM alquiler WHERE id=?";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionDB.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setLong(1, Alquiler.getId());
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

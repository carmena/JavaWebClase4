/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.model.Local;
import app.model.Socio;
import app.util.AccesoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class SocioDAO {

    public static void save(Socio socio) throws SQLException {
        String sql = "insert into socio(email,nombre,materno,paterno,celular,sexo,direccion)values(?,?,?,?,?,?,?)";
        PreparedStatement stm;

        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setString(1, socio.getEmail());
        stm.setString(3, socio.getNombres());
        stm.setString(4, socio.getMaterno());
        stm.setString(5, socio.getPaterno());
        stm.setString(5, socio.getCelular());
        stm.setString(5, socio.getSexo());
        stm.setString(5, socio.getDireccion());
        int n = stm.executeUpdate();

        cn.close();
        stm.close();
    }

    public static void update(Socio socio) throws SQLException {
        String sql = "update socio set email=?,nombre=?,materno=?,paterno=?,celular=?,sexo=?,direccion=? where id=?";
        PreparedStatement stm;



        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setString(1, socio.getEmail());
        stm.setString(3, socio.getNombres());
        stm.setString(4, socio.getMaterno());
        stm.setString(5, socio.getPaterno());
        stm.setString(5, socio.getCelular());
        stm.setString(5, socio.getSexo());
        stm.setString(5, socio.getDireccion());
        int n = stm.executeUpdate();

        cn.close();
        stm.close();

    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from socio where id=?";
        PreparedStatement stm;


        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setInt(1, id);
        int n = stm.executeUpdate();


        cn.close();
        stm.close();
    }

    public static Collection<Socio> listarSocio(int id) {
        Collection<Socio> lista = new ArrayList<Socio>();
        return null;
    }

    public static Socio getSocio(int id) throws SQLException {

        Socio socio = null;
        ResultSet rs;
        String sql = "select *from local where id=?";
        Connection cn = AccesoBD.obtenerConexion();
        PreparedStatement stm;
        stm = cn.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if (rs.next()) {
            socio = new Socio();
            socio.setDireccion(rs.getString(1));
            socio.setEmail(rs.getString(2));
            socio.setNombres(rs.getString(3));
            socio.setMaterno(rs.getString(4));
            socio.setPaterno(rs.getString(5));
            socio.setSexo(rs.getString(6));
            socio.setDireccion(rs.getString(7));
socio.setCelular(rs.getString(6));
        }
        cn.close();
        stm.close();
        rs.close();
        return socio;
    }
}

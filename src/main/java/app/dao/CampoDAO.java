package app.dao;

import app.model.Campo;
import app.model.Local;
import app.util.AccesoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CampoDAO {

    public static void save(Campo campo) throws SQLException {
        String sql = "insert into campo(descripcion,estado,tipo,costo_Hora,id_local)values(?,?,?,?,?)";
        PreparedStatement stm;


        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setString(2, campo.getDescripcion());
        stm.setInt(3, campo.getEstado());
        stm.setInt(4, campo.getTipo());
        stm.setDouble(5, campo.getCosto_Hora());
        stm.setObject(5,campo.getLocal());
        int n = stm.executeUpdate();

        cn.close();
        stm.close();
    }

    public static void update(Campo campo) throws SQLException {
    
       String sql = "update  campo set descripcion=?,estado=?,tipo=?,costo_Hora=?,id_local=?  where id=?";
        PreparedStatement stm;
        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setString(2, campo.getDescripcion());
        stm.setInt(3, campo.getEstado());
        stm.setInt(4, campo.getTipo());
        stm.setDouble(5, campo.getCosto_Hora());
        stm.setObject(6, campo.getLocal());
        stm.setInt(6, campo.getId());
        int n = stm.executeUpdate();

        cn.close();
        stm.close();
 }
    public static void delete(int id) throws SQLException {
        String sql = "delete from campo where id=?";
        PreparedStatement stm;

        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setInt(1, id);
        int n = stm.executeUpdate();


        cn.close();
        stm.close();
    }

    public static Campo listarCampo(int id) throws SQLException {
       Campo campo = null;
        ResultSet rs;
        String sql = "select *from campo where id=?";
        Connection cn = AccesoBD.obtenerConexion();
        PreparedStatement stm;
        stm = cn.prepareStatement(sql);
        stm.setInt(1, id);
        rs = stm.executeQuery();
        if (rs.next()) {
            campo = new Campo();
            campo.setId(rs.getInt(1));
            campo.setDescripcion(rs.getString(2));
            campo.setEstado(rs.getInt(3));
            campo.setTipo(rs.getInt(4));
            campo.setLocal((Local) rs.getObject(5));

        }
        cn.close();
        stm.close();
        rs.close();
        return campo;
    }

}

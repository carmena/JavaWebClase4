package app.dao;

import app.model.Administrador;
import app.model.Local;
import app.util.AccesoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
public class LocalDAO {

    public static void insert(Local loc) throws SQLException {
        String sql = "insert into local(direccion,descripcion,estado,maps,telefono)values(?,?,?,?,?)";
        PreparedStatement stm;


        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setString(1, loc.getDireccion());
        stm.setString(2, loc.getDescripcion());
        stm.setInt(3, loc.getEstado());
        stm.setString(4, loc.getMaps());
        stm.setString(5, loc.getTelefono());
        int n = stm.executeUpdate();


    }

    public static void update(Local loc) throws SQLException {
        String sql = "insert local set direccion=?,descripcion=?,estado=?,maps=?,telefono=? where id=?";
        PreparedStatement stm;


        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setString(1, loc.getDireccion());
        stm.setString(2, loc.getDescripcion());
        stm.setInt(3, loc.getEstado());
        stm.setString(4, loc.getMaps());
        stm.setString(5, loc.getTelefono());
        stm.setInt(6, loc.getId());
        int n = stm.executeUpdate();



    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from local where id=?";
        PreparedStatement stm;


        Connection cn = AccesoBD.obtenerConexion();
        stm = cn.prepareStatement(sql);
        stm.setInt(1, id);
        int n = stm.executeUpdate();



    }

    public static Local searchlocal(int id) throws SQLException {
        Local loc = null;
       ResultSet rs;
        String sql = "select *from local where id=?";
        Connection cn = AccesoBD.obtenerConexion();
        PreparedStatement stm;
        stm = cn.prepareStatement(sql);
        stm.setInt(1, id);
        rs=stm.executeQuery();
        if(rs.next()){
        loc=new Local();
        loc.setId(rs.getInt(1));
        loc.setDireccion(rs.getString(2));
         loc.setDescripcion(rs.getString(3));
        loc.setEstado(rs.getInt(4));
        loc.setMaps(rs.getString(5));
        loc.setTelefono(rs.getString(6));

        }
        return loc;
    }
    
    public static Collection<Local> listar() {
        Collection<Local> lista = new ArrayList<Local>();

        return lista;

    }
}

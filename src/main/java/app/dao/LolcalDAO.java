package app.dao;

import app.model.Local;
import app.util.AccesoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LolcalDAO {

    public static void insert(Local loc) {
        String sql = "insert into local(direccion,descripcion,estado,maps,telefono)values(?,?,?,?,?)";
        PreparedStatement stm;
        try {
            
            Connection cn=AccesoBD.obtenerConexion();
            stm=cn.prepareStatement(sql);
            stm.setString(1, loc.getDireccion());
            stm.setString(2, loc.getDescripcion());
            stm.setInt(3, loc.getEstado());
            stm.setString(4, loc.getMaps());
            stm.setString(5, loc.getTelefono());
           int n= stm.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(LolcalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void update(Local loc) {
    }

    public static void delete(int id) {
    }

    public static Local searchlocal(int id) {
        Local loc = null;

        return loc;

    }
}

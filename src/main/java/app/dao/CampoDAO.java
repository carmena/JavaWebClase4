package app.dao;

import app.model.Campo;
import app.model.Local;
import app.zelper.ConexionDB;
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


    
       
        
    }

    public static void update(Campo campo) throws SQLException {
    
       String sql = "update  campo set descripcion=?,estado=?,tipo=?,costo_Hora=?,id_local=?  where id=?";


 }
}

package app.controler.local;

import app.dao.LocalDAO;
import app.model.Local;
import java.sql.SQLException;

import java.util.Collection;

public class LocalService {

    public static Local save(Local local) throws SQLException {

        return LocalDAO.insert(local);

    }

    public static Local update(Local local) throws SQLException {

        return LocalDAO.update(local);

    }

    public Collection<Local> listar() throws SQLException {

        return LocalDAO.listar();
    }
    public Local get(int id) throws SQLException{
    
     return LocalDAO.searchlocal(id);
    }
}

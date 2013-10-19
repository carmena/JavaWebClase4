package app.controller.administrador;

import app.dao.AdmistradorDAO;
import app.dao.DAOExcepcion;
import app.model.Administrador;
import java.util.List;

public class AdministradorService {
     
    private AdmistradorDAO administradorDAO = null;
    
    public AdministradorService(){
        administradorDAO = new AdmistradorDAO();
    }
    
    public List<Administrador> list() throws DAOExcepcion {
        return administradorDAO.list();
    }

    public Administrador get(Administrador administrador) throws DAOExcepcion {
        return administradorDAO.get(administrador);
    }

    public Administrador save(Administrador administrador) throws DAOExcepcion {
        return administradorDAO.save(administrador);
    }
    
    public Administrador update(Administrador administrador) throws DAOExcepcion {
        return administradorDAO.update(administrador);
    }
    
    public void delete(Administrador administrador) throws DAOExcepcion {
        administradorDAO.delete(administrador);
    }
}

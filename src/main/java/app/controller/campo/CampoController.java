package app.controller.campo;

import app.controller.campo.CampoController;
import app.controller.campo.CampoService;
import app.dao.DAOExcepcion;
import app.model.Campo;
import app.model.Local;
import app.zelper.Constants;
import app.zelper.Helper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/campo"})
public class CampoController extends HttpServlet {

   private CampoService service;

    public CampoController() {
        service = new CampoService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int action = Helper.toInteger(request.getParameter("action"), Constants.ACTION_LIST);
        
        switch (action) {
            case Constants.ACTION_CREATE:
                this.create(request, response);
                break;
                
            case Constants.ACTION_UPDATE:
                this.update(request, response);
                break;

            case Constants.ACTION_DELETE:
                this.delete(request, response);
                break;

            default:
                this.list(request, response);
                break;
        }
    }
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Campo campo = new Campo();
        campo.setDescripcion(request.getParameter("descripcion"));
        campo.setEstado(Integer.parseInt(request.getParameter("estado")));
        campo.setTipo(Integer.parseInt(request.getParameter("telefono")));
        campo.setCosto_Hora(Double.parseDouble(request.getParameter("telefono")));
        
       // Local local= new Local();
        //local.setId(id);
       //campo.setLocal(request.getParameter("telefono"));
        Long id = Long.parseLong(request.getParameter("id"));
        if(id > 0){
            campo.setId(id);
            try {
                service.update(campo);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(CampoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                service.save(campo);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(CampoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect(request.getContextPath()+"/local");
    }
   
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Campo> campos=null;
        
        try {
            campos = service.list();
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CampoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("campos", campos);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/campo/campo.jsp");
        rd.forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("campo", new Local());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/campo/campoForm.jsp");
        rd.forward(request, response);

    }
      protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Campo campo = new Campo();
        campo.setId(Long.parseLong(request.getParameter("id")));
        try {
            request.setAttribute("local", service.get(campo));
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CampoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/campo/campoForm.jsp");
        rd.forward(request, response);

    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Campo campo = new Campo();
        campo.setId(Long.parseLong(request.getParameter("id")));
        try {
            service.delete(campo);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(CampoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath()+"/campo");

    }
  
}

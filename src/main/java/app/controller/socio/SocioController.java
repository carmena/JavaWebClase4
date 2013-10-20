package app.controller.socio;

import app.controller.local.LocalController;
import app.controller.local.LocalService;
import app.dao.DAOExcepcion;
import app.model.Local;
import app.model.Socio;
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

@WebServlet(urlPatterns = {"/socio"})
public class SocioController extends HttpServlet {
      private SocioService service;
 public SocioController() {
        service = new SocioService();
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

        Socio socio = new Socio();
        
        
        Long id = Long.parseLong(request.getParameter("id"));
        if(id > 0){
            socio.setId(id);
            try {
                service.update( socio);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                service.save( socio);
            } catch (DAOExcepcion ex) {
                Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect(request.getContextPath()+"/socio");
    }
   
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Socio> socios=null;
        
        try {
            socios= service.list();
        } catch (DAOExcepcion ex) {
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("socios",socios);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/socio/socio.jsp");
        rd.forward(request, response);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("socio", new Socio());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/socio/socioForm.jsp");
        rd.forward(request, response);

    }
      protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Socio socio = new Socio();
        socio .setId(Long.parseLong(request.getParameter("id")));
        try {
            request.setAttribute("socio", service.get(socio));
        } catch (DAOExcepcion ex) {
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adm/socio/socioForm.jsp");
        rd.forward(request, response);

    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         Socio socio = new Socio();
        socio.setId(Long.parseLong(request.getParameter("id")));
        try {
            service.delete(socio);
        } catch (DAOExcepcion ex) {
            Logger.getLogger(LocalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath()+"/socio");

    }

}

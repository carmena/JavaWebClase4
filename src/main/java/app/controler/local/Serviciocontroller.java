/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controler.local;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LAB704-00
 */
@WebServlet(name = "Serviciocontroller", urlPatterns = {"/Serviciocontroller"})
public class Serviciocontroller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
       
        RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/adm/servicio/servicio.jsp");
        rd.forward(request, response);
                
                
    }




}

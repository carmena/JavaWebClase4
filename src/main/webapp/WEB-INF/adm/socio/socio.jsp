<%-- 
    Document   : socio
    Created on : 20/10/2013, 11:36:29 AM
    Author     : LAB704-00
--%>

<%@page import="app.zelper.Constants"%>
<%@page import="app.model.Socio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Socio> socios= (List<Socio>) request.getAttribute("socios");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Socios </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%@include file="/public/header.jsp" %>
    </head>

    <body>

        <%@include file="/public/menuGeneral.jsp" %>

        <div class="container-fluid">
            <div class="row-fluid">

                <%@include file="/public/menuAdm.jsp" %>

                <div class="span9">
                    <div class="row">
                        <a class=" btn btn-primary pull-right" href="<%=contextPath%>/socio?action=<%=Constants.ACTION_CREATE%>"> Nuevo </a>
                        <h1> Socios </h1>
                    </div>
                    
                    <% if (!socios.isEmpty()) {%>
                    <table class="table table-striped table-hover"> 
                        <thead>
                        <th> Descripción </th>
                        <th> Dirección </th>
                        <th> Teléfono </th>
                        </thead>
                        <tbody>
                            <% for (Socio socio : socios) {
                            
                           
                            %>
                            <tr>
                                <td> <%=socio.getNombres()%> </td>
                                <td> <%=socio.getPaterno()%> </td>
                                <td>  socio.getSexo(); </td>
                                <td> 
                                    <div class="btn-group">
                                        <a class="dropdown-toggle" data-toggle="dropdown" role="menu"  href="#">
                                          <i class="icon-cog"></i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li>
                                                <a href="<%=contextPath%>/socio?action=<%=Constants.ACTION_UPDATE%>&id=<%=socio.getId()%>">
                                                Editar<a>
                                            </li>
                                            <li>
                                                <a href="<%=contextPath%>/socio?action=<%=Constants.ACTION_DELETE%>&id=<%=socio.getId()%>">
                                                    Eliminar<a>
                                            </li>
                                        </ul>
                                      </div>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                        
                    <% }%>
                </div>
            </div>


            <hr>
        </div>

        <%@include file="/public/footer.jsp" %>
    </body>
</html>
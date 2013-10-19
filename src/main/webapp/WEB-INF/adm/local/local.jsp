<%-- 
    Document   : local
    Created on : 13/10/2013, 01:33:30 PM
    Author     : LAB704-00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="/public/menuGeneral.jsp" %>
        <div class="container-fluid">
            <div class="row-fluid">
              <%@include file="/public/menuAdm.jsp" %>
                    <div class="span9">
                 
                </div>
            </div>
        </div>
      <%@include file="/public/footer.jsp" %>
    </body>
</html>

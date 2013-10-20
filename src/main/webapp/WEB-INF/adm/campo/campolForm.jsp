<%@page import="app.model.Local"%>
<%@page import="app.zelper.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Campos Deportivos - Nuevo Campo </title>
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
                        <h1> Nuevos Campos Deportivos </h1>
                    </div>

                    <form action="<%=contextPath%>/campo" method="post">
                        
                        <input hidden="id" value="${campo.id}" name="id">
                        
                        <div class="control-group">
                            <label class="control-label">Descripción</label>
                            <div class="controls">
                                <input type="text" name="descripcion" value="${campo.descripcion}">
                            </div>
                        </div>

                            
                        <div class="control-group">
                            <label class="control-label">Estado</label>
                            <div class="controls">
                                <input type="text" name="estado" value="${campo.estado}">
                            </div>
                        </div>
                        
                        <div class="control-group">
                            <label class="control-label">Tipo</label>
                            <div class="controls">
                                <input type="text" name="tipo" value="${campo.tipo}">
                            </div>
                        </div>
                          
                        <div class="control-group">
                            <label class="control-label">Costo por Hora</label>
                            <div class="controls">
                                <input type="text" name="costo_Hora" value="${campo.tipo}">
                            </div>
                        </div>
                            
                        <div class="control-group">
                            <label class="control-label">Local</label>
                            <div class="controls">
                                <input type="text" name="loca" value="${campo.tipo}">
                            </div>
                        </div>
                      
                        <div class="control-group">
                            <div class="controls">
                                <a class="btn" href="<%=contextPath%>/campo">Cancelar</a>
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


            <hr>
        </div>

        <%@include file="/public/footer.jsp" %>
    </body>
</html>

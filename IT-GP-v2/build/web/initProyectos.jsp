<%-- 
    Document   : admin
    Created on : 28-abr-2023, 13:04:27
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Language" content="es">
        <s:head/>
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/proyecto.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contenedor">
            <s:include value="/header.jsp"/>
            <h1>Proyectos</h1>
            <s:if test="%{#session.logged.admin == true}">
                <s:form action="formularioProyecto">
                    <s:submit value="Crear proyecto"/>
                </s:form>
            </s:if>
            <s:iterator value="listaProyectos" var="proy">
                <div class="peg">
                    <s:url id="url_action" action="visualizarProyectos">
                        <s:param name="idProyecto" value="#proy.idProyecto"/>
                    </s:url>
                    <a id="enlsub" href="<s:property value="#url_action"/>"><b><s:property value="#proy.idProyecto"/> <s:property value="#proy.nombre"/></b></a><br>
                    <s:property value="#proy.fechaInicio"/> - <s:property value="#proy.fechaFin"/><br>
                    <s:property value="#proy.descripcion"/>
                </div>
                <br>
            </s:iterator>
            <s:include value="/footer.jsp"/>
        </div>
    </body>
</html>


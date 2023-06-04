<%-- 
    Document   : proyectoForm
    Created on : 05-may-2023, 8:20:46
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/proyecto.css">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1>Edición Proyecto</h1>
        <s:form action="editarProyecto">
            <s:textfield name="proyecto.idProyecto" value="%{proyecto.idProyecto}" label="Id" readonly="true"/>
            <s:textfield name="proyecto.nombre" value="%{proyecto.nombre}" label="Nombre"/>
            <s:textarea name="proyecto.descripcion" value="%{proyecto.descripcion}" label="Descripcion"/>
            <s:textfield name="proyecto.fechaInicio" value="%{proyecto.fechaInicio}" label="Fecha Inicio"/>
            <s:textfield name="proyecto.fechaFin" value="%{proyecto.fechaFin}" label="Fecha Fin"/>
            <s:submit value="Editar"/>
        </s:form>
        <s:form action="visualizarProyectos">
            <s:submit value="Cancelar"/>
            <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
        </s:form>
        <s:include value="/footer.jsp"/>
    </body>
</html>

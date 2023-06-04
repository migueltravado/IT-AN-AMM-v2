<%-- 
    Document   : proyectoFormView
    Created on : 09-may-2023, 5:15:04
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1>Edición Proyecto</h1>
        <s:form action="crearProyecto">
            <s:textfield name="proyecto.idProyecto" label="Id" readonly="true"/>
            <s:textfield name="proyecto.nombre" label="Nombre"/>
            <s:textarea name="proyecto.descripcion" label="Descripcion"/>
            <s:textfield name="proyecto.fechaInicio" label="Fecha Inicio"/>
            <s:textfield name="proyecto.fechaFin" label="Fecha Fin"/>
            <s:submit value="Crear"/>
        </s:form>
        <s:form action="cargarProyectos">
            <s:submit value="Cancelar"/>
        </s:form>
        <s:include value="/footer.jsp"/>
    </body>
</html>

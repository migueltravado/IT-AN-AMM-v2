<%-- 
    Document   : adicionParticipacionView
    Created on : 05-may-2023, 10:17:49
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head/>
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1>Participacion</h1>
        <h3>ID Proyecto: <s:property value="idProyecto"/></h3>
        <h3>ID Persona: <s:property value="idPersona"/></h3>
        <s:form action="adicionParticipacion">
            <s:textfield name="cuota" label="Cuota"/>
            <s:select name="iddRol" list="listaRol" listKey="idRol" listValue="%{nombre}" label="Rol"/>
            <s:hidden name="idPersona" value="%{idPersona}"/>
            <s:hidden name="idProyecto" value="%{idProyecto}"/>
            <s:submit value="Añadir"/>
        </s:form>
    </body>
</html>

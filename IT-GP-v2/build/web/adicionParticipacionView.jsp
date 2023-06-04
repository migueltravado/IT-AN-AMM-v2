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
        <link rel="stylesheet" type="text/css" href="CSS/proyecto.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:i18n name="Controlador.Actions.AdicionParticipacionAction">
        <s:include value="/header.jsp"/>
        <h1><s:text name="Participacion"/></h1>
        <h3><s:text name="idProyecto.form"/><s:property value="idProyecto"/></h3>
        <h3><s:text name="idPersona"/><s:property value="idPersona"/></h3>
        <s:form action="adicionParticipacion">
            <s:textfield name="cuota" key="Cuota"/>
            <s:select name="iddRol" list="listaRol" listKey="idRol" listValue="%{nombre}" key="Rol"/>
            <s:hidden name="idPersona" key="%{idPersona}"/>
            <s:hidden name="idProyecto" key="%{idProyecto}"/>
            <s:submit value="Añadir"/>
        </s:form>
        <s:include value="/footer.jsp"/>
            </s:i18n>
    </body>
</html>

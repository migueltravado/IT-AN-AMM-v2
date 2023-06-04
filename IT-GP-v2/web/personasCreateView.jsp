<%-- 
    Document   : personasCreate
    Created on : 26-may-2023, 18:12:24
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/persona.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <s:i18n name="Controlador.Actions.CUDPersonaAction">
            <s:form action="crearPersona">
                <s:textfield name="persona.nombre" key="nombre.form"/>
                <s:textfield name="persona.apellidos" key="apellidos.form"/>
                <s:textfield name="persona.dni" key="dni.form"/>
                <s:checkbox name="persona.admin" key="admin.form"/>
                <s:textfield name="persona.usuario" key="usuario.form"/>
                <s:textfield name="persona.password" key="password.form"/>
                <s:submit key="enviar.button"/>
            </s:form>
            <s:include value="/footer.jsp"/>
        </s:i18n>
        
    </body>
</html>

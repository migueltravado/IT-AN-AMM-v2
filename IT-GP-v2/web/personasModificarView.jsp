<%-- 
    Document   : personasModificarView
    Created on : 26-may-2023, 20:18:56
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <s:i18n name="Controlador.Actions.CUDPersonaAction">
            <s:form action="modPersona">
                <s:hidden name="persona.idPersona" value="%{persona.idPersona}" />
                <s:textfield name="persona.nombre" key="nombre.form" value="%{persona.nombre}" />
                <s:textfield name="persona.apellidos" key="apellidos.form" value="%{persona.apellidos}"/>
                <s:textfield name="persona.dni" key="dni.form" value="%{persona.dni}"/>
                <s:checkbox name="persona.admin" key="admin.form" value="%{persona.admin}"/>
                <s:textfield name="persona.usuario" key="usuario.form" value="%{persona.usuario}"/>
                <s:textfield name="persona.password" key="password.form" value="%{persona.password}"/>
                <s:submit key="enviar.button"/>
            </s:form>
        </s:i18n>
    </body>
</html>

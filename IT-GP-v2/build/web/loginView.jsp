<%-- 
    Document   : login
    Created on : 28-abr-2023, 12:59:20
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <s:form action="loginAction" id="login">
            <img src="img/logoe.png" id="Eimg">
            <s:textfield name="persona.usuario" label="Usuario"/>
            <s:password name="persona.password" label="Contraseña"/>
            <s:submit value="Login"/>
        </s:form>
    </body>
</html>

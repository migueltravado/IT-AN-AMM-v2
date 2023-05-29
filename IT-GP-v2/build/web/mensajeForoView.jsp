<%-- 
    Document   : foroProyectoView
    Created on : 29-may-2023, 17:39:41
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
        <s:iterator value="mensajes" var="m">
            <s:property value="#m.envio.persona.nombre"/>
            <s:property value="#m.contenido"/>
        </s:iterator>
    </body>
</html>

<%-- 
    Document   : personasView
    Created on : 10-may-2023, 12:42:57
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1>Personas</h1>
        <div>
            <s:iterator value="listaPersonas" var="persona">
                <div class="peg">
                    <b><s:property value="#persona.nombre"/> <s:property value="#persona.apellidos"/></b></br>
                    DNI: <s:property value="#persona.dni"/></br>
                    ID: <s:property value="#persona.idPersona"/></br>
                    Usuario: <s:property value="#persona.usuario"/>
                </div>
                </br>
            </s:iterator>
        </div>
    </body>
</html>

<%-- 
    Document   : addRolView
    Created on : 04-jun-2023, 2:17:44
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/rol.css">
        <title>JSP Page</title>
    </head>
    <body>
         <s:include value="/header.jsp"/>
         <s:form action="crearRol">
             <s:hidden name="rol.idRol" value="%{rol.idRol}" />
             <s:textfield name="rol.nombre" label="Nombre" />
             <s:textfield name="rol.descripcion" label="Descripcion" />
             <s:textfield name="rol.acceso" label="Acceso"/>
             <s:submit value="Enviar" />
         </s:form> 
   </body>
</html>

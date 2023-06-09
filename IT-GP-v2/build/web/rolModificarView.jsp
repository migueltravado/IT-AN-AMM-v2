<%-- 
    Document   : rolModificar
    Created on : 04-jun-2023, 2:11:50
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Language" content="es">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/roles.css">
        <title>JSP Page</title>
    </head>
    <body>
         <s:include value="/header.jsp"/>
         <s:form action="modRol">
             <s:hidden name="rol.idRol" value="%{rol.idRol}" />
             <s:textfield name="rol.nombre" label="Nombre" value="%{rol.nombre}" />
             <s:textfield name="rol.descripcion" label="Descripcion" value="%{rol.descripcion}" />
             <s:textfield name="rol.acceso" label="Acceso" value="%{rol.acceso}" />
             <s:submit value="Enviar" />
         </s:form>
    </body>
    <s:include value="/footer.jsp"/>
</html>

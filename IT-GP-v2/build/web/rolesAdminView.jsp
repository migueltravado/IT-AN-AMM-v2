<%-- 
    Document   : rolesAdminView
    Created on : 04-jun-2023, 1:58:09
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
        <h1>ROLES</h1>
        <s:form action="crearRolVista">
            <s:submit value="Crear Rol" />
        </s:form>
        <table>
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Descripción</td>
                <td>Modificar</td>
            </tr>
            <s:iterator value="roles" var="rol">
                <tr>
                    <td><s:property value="#rol.idRol" /></td>
                    <td><s:property value="#rol.nombre" /></td>
                    <td><s:property value="#rol.descripcion" /></td>
                    <td><s:form action="modificaRol">
                            <s:hidden value="%{#rol.idRol}" name="idRol"/>
                            <s:submit value="Modificar" />
                        </s:form></td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>

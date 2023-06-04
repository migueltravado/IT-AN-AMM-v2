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
        <meta http-equiv="Content-Language" content="es">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/roles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1>Roles</h1>
        <s:form action="crearRolVista">
            <s:submit value="Crear Rol" />
        </s:form>
        <table>
            <s:iterator value="roles" var="rol">
                <div class="rol">
                    <tr>
                        <td id="ops">ID:<s:property value="#rol.idRol" /> / <s:property value="#rol.nombre" /></td>
                        <td id="ops"><s:property value="#rol.descripcion" /></td>
                        <td><s:form action="modificaRol">
                    </div>
                    <s:hidden value="%{#rol.idRol}" name="idRol"/>
                    <s:submit value="Modificar"/>
                </s:form></td>
        </tr>
    </s:iterator>
</table>
<s:include value="/footer.jsp"/>
</body>
</html>

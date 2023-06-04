<%-- 
    Document   : forosAdminView
    Created on : 29-may-2023, 13:08:27
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/foros.css">
        <title>JSP Page</title>
    </head>
    <body>

        <s:include value="/header.jsp"/>

        <h1>Foros</h1>
        <table>
            <tr>
                <td>Foro Nombre Proyecto</td>
                <td>Descripción</td>
            </tr>
            <s:iterator value="foros" var="foro">
                <div class="for">
                    <tr>
                        <s:url id="url_action" action="getForo">
                            <s:param name="idForo" value="#foro.idForo"/>
                        </s:url>
                        <td><a href="<s:property value='#url_action'/>">Foro <s:property value='#foro.proyecto.nombre'/></a></td>
                        <td><s:property value="#foro.descripcion"/></td>
                    </tr>
                </div>
            </s:iterator>
        </table>
        <s:include value="/footer.jsp"/>

    </body>
</html>
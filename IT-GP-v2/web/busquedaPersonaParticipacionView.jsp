<%-- 
    Document   : adicionParticipanteProyecto
    Created on : 05-may-2023, 9:43:23
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/proyecto.css">
        <s:head/>
    </head>
    <body>
        <s:i18n name="Controlador.Actions.AdicionParticipacionAction">
        <s:include value="/header.jsp"/>
        <s:form action="busquedaPersonaParticipacion">
            <s:textfield name="idPersona" key="BusquedaDNI"/>
            <s:hidden name="idProyecto" value="%{idProyecto}"/>
            <s:submit value="Buscar" key="Buscar"/>
        </s:form>
        <table border="1" id="table_bus">
            <tr>
                <td><s:text name="ID"/></td>
                <td><s:text name="Nombre"/></td>
                <td><s:text name="Apellidos"/></td>
                <td><s:text name="Dni"/></td>
                <td><s:text name="Añadir"/></td>
            </tr>
            <s:iterator value="listaPersona" var="pers">
                <tr>
                    <td><s:property value="#pers.idPersona"/></td>
                    <td><s:property value="#pers.nombre"/></td>
                    <td><s:property value="#pers.apellidos"/></td>
                    <td><s:property value="#pers.dni"/></td>
                    <td>
                        <s:form action="formularioParticipacion">
                            <s:submit value="Añadir" key="Añadir"/>
                            <s:hidden name="idPersona" value="%{#pers.idPersona}"/>
                            <s:hidden name="idProyecto" value="%{idProyecto}"/>
                        </s:form>
                    </td>
                </tr>
            </s:iterator>
                
            </s:i18n>
        </table>
        <s:include value="/footer.jsp"/>

    </body>
</html>

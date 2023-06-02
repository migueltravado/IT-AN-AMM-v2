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
        <link rel="stylesheet" type="text/css" href="CSS/persona.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>

        <s:i18n name="Controlador.Actions.CUDPersonaAction">
            <h1><s:text name="personas.text"/></h1>
            <div>
                <s:if test="%{#session.logged.admin == true}">
                    <s:form action="creaPersonaButton">
                        <s:submit value="Añadir persona"/>
                    </s:form>
                </s:if>
            </div>
            <div>
                <s:iterator value="listaPersonas" var="persona">
                    <div class="per">
                        <b><s:property value="#persona.nombre"/> <s:property value="#persona.apellidos"/></b></br>
                        <s:text name="dni.form"/>: <s:property value="#persona.dni"/></br>
                        ID: <s:property value="#persona.idPersona"/></br>
                        <s:text name="usuario.form"/>: <s:property value="#persona.usuario"/>
                        <s:if test="%{#session.logged.admin == true}">
                            <s:form action="modificaPersona">
                                <s:hidden name="persona.nombre" value="%{#persona.nombre}"/>
                                <s:hidden name="persona.apellidos" value="%{#persona.apellidos}"/>
                                <s:hidden name="persona.dni" value="%{#persona.dni}"/>
                                <s:hidden name="persona.idPersona" value="%{#persona.idPersona}"/>
                                <s:hidden name="persona.usuario" value="%{#persona.usuario}"/>
                                <s:hidden name="persona.admin" value="%{#persona.admin}"/>
                                <s:hidden name="persona.password" value="%{#persona.password}"/>
                                <s:submit key="mod.button"/>
                            </s:form>
                            <s:form action="eliminaPersona">
                                <s:hidden name="persona.nombre" value="%{#persona.nombre}"/>
                                <s:hidden name="persona.apellidos" value="%{#persona.apellidos}"/>
                                <s:hidden name="persona.dni" value="%{#persona.dni}"/>
                                <s:hidden name="persona.idPersona" value="%{#persona.idPersona}"/>
                                <s:hidden name="persona.usuario" value="%{#persona.usuario}"/>
                                <s:hidden name="persona.admin" value="%{#persona.admin}"/>
                                <s:hidden name="persona.password" value="%{#persona.password}"/>
                                <s:submit key="eliminar.button"/>
                            </s:form>
                        </s:if>
                    </div>
                    </br>
                </s:iterator>
            </div>
        </s:i18n>
    </body>
</html>

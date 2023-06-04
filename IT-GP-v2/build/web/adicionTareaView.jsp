<%-- 
    Document   : adicionTareaView
    Created on : 09-may-2023, 3:58:17
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head/>
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/proyecto.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:i18n name="Controlador.Actions.AdicionTareaAction">
        <s:include value="/header.jsp"/>
        <h1><s:text name="Tarea"/></h1>
        <h3><s:text name="idProyecto.form"/><s:property value="idProyecto"/></h3>
        <s:form action="adicionTarea">
            <s:textfield name="tarea.nombre" key="Nombre"/>
            <s:textarea name="tarea.descripcion" key="Descripcion"/>
            <s:textfield name="tarea.fechaInicio" key="FechaInicio"/>
            <s:textfield name="tarea.fechaFin" key="FechaFin"/>
            <s:select name="idParticipacion" list="listaParticipacion" 
                      listKey="idParticipacion" listValue="%{persona.nombre}" key="Persona"/>
            <s:select name="idTarea" list="listaTarea" 
                      listKey="idTarea" listValue="%{nombre}" key="TareaPredecesora"/>
            <s:hidden name="idProyecto" value="%{idProyecto}"/>
            <s:submit value="Añadir" key="Añadir"/>
        </s:form>
        <s:include value="/footer.jsp"/>
        </s:i18n>
    </body>
</html>

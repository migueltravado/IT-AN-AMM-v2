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
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1>Tarea</h1>
        <h3>ID Proyecto: <s:property value="idProyecto"/></h3>
        <s:form action="adicionTarea">
            <s:textfield name="tarea.nombre" label="Nombre"/>
            <s:textarea name="tarea.descripcion" label="Descripcion"/>
            <s:textfield name="tarea.fechaInicio" label="Fecha inicio"/>
            <s:textfield name="tarea.fechaFin" label="Fecha Fin"/>
            <s:select name="idParticipacion" list="listaParticipacion" 
                      listKey="idParticipacion" listValue="%{persona.nombre}" label="Persona"/>
            <s:select name="idTarea" list="listaTarea" 
                      listKey="idTarea" listValue="%{nombre}" label="Tarea Predecesora"/>
            <s:hidden name="idProyecto" value="%{idProyecto}"/>
            <s:submit value="Añadir"/>
        </s:form>
    </body>
</html>

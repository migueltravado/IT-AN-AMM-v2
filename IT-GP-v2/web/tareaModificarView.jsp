<%-- 
    Document   : modificaTareaView
    Created on : 26-may-2023, 23:30:24
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:i18n name="Controlador.Actions.ModificarTareaAction">
            <s:include value="/header.jsp"/>
            <h1><s:text name="tarea.form"/></h1>
            <h3>ID <s:text name="proyecto.form" />: <s:property value="idProyecto"/></h3>

            <s:form action="modTarea">
                <s:textfield name="tarea.nombre" key="nombre.form" value="%{tarea.nombre}" />
                <s:textarea name="tarea.descripcion" key="descripcion.form" value="%{tarea.descripcion}"/>
                <s:textfield name="tarea.fechaInicio" key="fechaInicio.form" value="%{tarea.fechaInicio}"/>
                <s:textfield name="tarea.fechaFin" key="fechaFin.form" value="%{tarea.fechaFin}"/>

                <s:select name="idPersona" list="personas" listKey="idPersona" listValue="nombre" key="persona.form" />

                <s:select name="idTareaPredecesora" list="tareas" listKey="idTarea" listValue="nombre" key="tareaPre.form"/>


                <s:checkbox name="tarea.completado" key="completado.form" value="%{tarea.completado}" fieldValue="%{tarea.completado}" />
                <s:hidden name="idProyecto" value="%{idProyecto}" />
                <s:hidden name="tarea.idTarea" value="%{tarea.idTarea}"/>
                <s:submit key="mod.button"/>
            </s:form>
        </s:i18n>
    </body>
</html>

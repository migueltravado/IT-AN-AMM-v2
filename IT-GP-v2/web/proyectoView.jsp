<%-- 
    Document   : proyecto
    Created on : 05-may-2023, 5:07:51
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:head/>
        <link rel="stylesheet" type="text/css" href="CSS/general.css">
        <link rel="stylesheet" type="text/css" href="CSS/proyecto.css">
        <link rel="stylesheet" type="text/css" href="CSS/persona.css">
        <title>JSP Page</title>
    </head>
    <body>
        <s:include value="/header.jsp"/>
        <h1 style="margin-bottom:10px"><s:property value="proyecto.nombre"/></h1>
        <div>
            <span><b>Fecha inicio:</b> <s:date name="proyecto.fechaInicio" format="dd/MM/yyyy"/></span>
            <span style="margin-left:10px;"><b>Fecha fin:</b> <s:date name="proyecto.fechaFin" format="dd/MM/yyyy"/></span>
            <h3 style="margin-bottom:10px">Descripcion</h3>
            <s:property value="proyecto.descripcion"/>
            <h4 style="margin-bottom:10px">Informes</h4>
            <s:if test="%{proyecto.informes.size() ==0}">
                No existen informes
            </s:if>
            <s:else>
                <s:iterator value="proyecto.informes" var="informe">
                    <div>Informe <s:property value="#informe.idInforme"/></div>
                </s:iterator>
            </s:else>
            <div>
                <h4 style="margin-bottom:10px">Foro: </h4>
                <s:if test="%{proyecto.foro == null}">

                    <s:form action="crearForo">
                        <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
                        <s:textfield name="descripcion" label="Descripcion"/>
                        <s:submit value="Crear Foro"/>
                    </s:form>

                </s:if>
                <s:else>
                    <div>
                        <s:url id="url_action" action="getForo">
                            <s:param name="idForo" value="proyecto.foro.idForo"/>
                        </s:url>
                        <a href="<s:property value="#url_action"/>"><b><s:property value="proyecto.foro.descripcion"/></b></a><br>
                    </div>
                </s:else>
            </div>
        </div>
        <div>
            <h3 style="margin-bottom:10px">Tareas</h3>
            <table class="table-style">
                <tr id="titulos">
                    <td>ID</td>
                    <td>Nombre</td>
                    <td>Fecha inicio</td>
                    <td>Fecha fin</td>
                    <td>Persona</td>
                    <td>Sucesora(s) (ID)</td>
                    <td>Completado</td>
                    <s:if test="%{#session.logged.admin == true}">
                        <td>Modificar</td>
                        <td>Eliminar</td>
                    </s:if>
                </tr>
                <s:iterator value="listaTareas" var="tarea">
                    <tr>
                        <td><s:property value="#tarea.idTarea"/></td>
                        <td><s:property value="#tarea.nombre"/></td>
                        <td><s:property value="#tarea.fechaInicio"/></td>
                        <td><s:property value="#tarea.fechaFin"/></td>
                        <td><s:property value="#tarea.participacion.persona.nombre"/></td>
                        <s:if test="#tarea.tareas.isEmpty()">
                            <td>Ninguna</td>
                        </s:if>
                        <s:else>
                            <td><s:iterator value="#tarea.tareas" var="t">
                                    <s:property value="#t.idTarea" />
                                    <s:if test="!#t.last">, </s:if>
                                </s:iterator>
                            </td>
                        </s:else>
                        <td>
                            <s:if test="#tarea.completado != true">
                                <s:form action="checkTarea">
                                    <s:hidden name="idTarea" value="%{#tarea.idTarea}"/>
                                    <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
                                    <s:submit name="submitTarea" value="Pendiente"/>
                                    <s:fielderror fieldName="idTarea"/>
                                </s:form>
                            </s:if>
                            <s:else>
                                Completado
                            </s:else>
                        </td>
                        <s:if test="%{#session.logged.admin == true}">
                            <td>
                                <s:form action="modificaTarea">
                                    <s:hidden name="tarea.idTarea" value="%{#tarea.idTarea}"/>
                                    <s:hidden name="tarea.nombre" value="%{#tarea.nombre}"/>
                                    <s:hidden name="tarea.fechaInicio" value="%{#tarea.fechaInicio}"/>
                                    <s:hidden name="tarea.fechaFin" value="%{#tarea.fechaFin}"/>
                                    <s:hidden name="tarea.descripcion" value="%{#tarea.descripcion}"/>
                                    <s:hidden name="tarea.completado" value="%{tarea.completado}"/>
                                    <s:hidden name="tarea.idTareaPredecesora" value="%{proyecto.idTareaPredecesora}"/>
                                    <s:hidden name="idProyecto" value="%{idProyecto}"/>
                                    <s:submit value="Modificar" />
                                </s:form>
                            </td>
                            <td>
                                <s:form action="eliminarTarea">
                                    <s:hidden name="idTarea" value="%{#tarea.idTarea}"/>
                                    <s:submit value="Eliminar" />
                                </s:form>
                            </td>
                        </s:if>
                    </tr>
                </s:iterator>
            </table>
        </div>

        <s:if test="%{#session.logged.admin == true}">
            <div style="margin:10px 0;">
                <s:iterator value="listaParticipacion" var="part">
                    <div class="per">
                        Participante: <s:property value="#part.persona.nombre"/> <s:property value="#part.persona.apellidos"/></br>
                        Rol: <s:property value="#part.rol.nombre"/></br>
                        Cuota: <s:property value="#part.cuota"/></br>
                    </div>
                </s:iterator>
            </div>
            <div class="buttons-list">
                <div>
                    <s:form action="formularioEdicionProyecto">
                        <s:submit value="Editar"/>
                        <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
                    </s:form>
                </div>
                <div>
                    <s:form action="cargaPersonas">
                        <s:submit value="Añadir participantes"/>
                        <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
                    </s:form>
                </div>
                <div>
                    <s:form action="formularioTarea">
                        <s:submit value="Añadir tarea"/>
                        <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
                    </s:form>
                </div>
                <div>
                    <s:form action="eliminarProyecto">
                        <s:submit value="Eliminar"/>
                        <s:hidden name="idProyecto" value="%{proyecto.idProyecto}"/>
                    </s:form>
                </div>
            </div>
        </s:if>
        <s:include value="/footer.jsp"/>
    </body>
</html>

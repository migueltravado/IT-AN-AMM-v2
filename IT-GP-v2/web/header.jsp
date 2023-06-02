<%-- 
    Document   : header
    Created on : 10-may-2023, 12:31:44
    Author     : miguel.travado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .header, .buttons-list {
                display: block;
                margin: 0;
            }

            .header div,  .buttons-list div{
                display: inline-block;
                margin: 0;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="%{#session.logged == null}">
            <script>
                window.location.href = "loginView.jsp";
            </script>
        </s:if>
        <div class="header">
            <div>
                <s:url id="url_action_proyectos" action="cargaProyectos"/>
                <a href="<s:property value="#url_action_proyectos"/>">Proyectos</a>
            </div>
            <div>
                <s:url id="url_action_foros" action="cargaForos"/>
                <a href="<s:property value="#url_action_foros"/>">Foros</a>
            </div>
            <s:if test="%{#session.logged.admin == true}">
                <div>
                    <s:url id="url_action_personas" action="cargaPersonasAdmin"/>
                    <a href="<s:property value="#url_action_personas"/>">Personas</a>
                </div>
                <div>
                    <s:url id="url_action_roles" action="cargaRoles"/>
                    <a href="<s:property value="#url_action_proyectos"/>">Roles</a>
                </div>
            </s:if>
            <div class="logout">
                <s:form action="logout">
                    <s:submit value="Log out"/>
                </s:form>
            </div>
        </div>
    </body>
</html>

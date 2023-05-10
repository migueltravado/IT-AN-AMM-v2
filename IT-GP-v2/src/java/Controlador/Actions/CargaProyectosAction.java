/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;
import java.util.*;
import Modelo.DAO.ProyectoDAO;
import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Persona;
import Modelo.POJOs.Proyecto;
import Modelo.POJOs.Tarea;
import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author miguel.travado
 */
public class CargaProyectosAction extends ActionSupport {
    private List<Proyecto> listaProyectos;
    private Map<Integer, List<Tarea>> mapTarea;
    private Proyecto proyecto;
    
    public CargaProyectosAction() {
    }
    
    public String execute() throws Exception {
        ProyectoDAO daoProyecto = new ProyectoDAO();
        TareaDAO daoTarea = new TareaDAO();
        Map session = (Map) ActionContext.getContext().getSession();
        Persona persona = (Persona)session.get("logged");
        if(persona.isAdmin()){
            setListaProyectos(daoProyecto.getProyectos());
        }
        else{
            setListaProyectos(daoProyecto.getProyectosPorPersona(persona.getIdPersona()));
        }
        return SUCCESS;
    }

    public Map<Integer, List<Tarea>> getMapTarea() {
        return mapTarea;
    }

    public void setMapTarea(Map<Integer, List<Tarea>> mapTarea) {
        this.mapTarea = mapTarea;
    }
    
    public void validate(){
        
    }

    public List<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;
import Modelo.DAO.ForoDAO;
import java.util.*;
import Modelo.DAO.ProyectoDAO;
import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Foro;
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
    
    /**
     * Método que carga el listado de proyecto del usuario logeado
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        // DAOs necesarios para la obtención de proyectos y tareas
        ProyectoDAO daoProyecto = new ProyectoDAO();
        TareaDAO daoTarea = new TareaDAO();
        // Obtención de la persona logeada en el sistema
        Map session = (Map) ActionContext.getContext().getSession();
        Persona persona = (Persona)session.get("logged");
        // Verificación de si la persona es admin o no
        if(persona.isAdmin()){
            // Si la persona es administradora, se le muestran todos los proyecto existentes
            setListaProyectos(daoProyecto.getProyectos());
        }
        else{
            // Si la persona no es administradora, se le mostrarán solo los proyecto
            // en los que participe
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

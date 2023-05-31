/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ParticipacionDAO;
import Modelo.DAO.PersonaDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Participacion;
import Modelo.POJOs.Persona;
import Modelo.POJOs.Proyecto;
import Modelo.POJOs.Tarea;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author miguel.travado
 */
public class VisualizarProyectoAction extends ActionSupport {

    private int idProyecto;
    private Proyecto proyecto;
    private List<Tarea> listaTareas;
    private List<Participacion> listaParticipacion;

    public VisualizarProyectoAction() {
    }

    /**
     * Método que permite la visualización de un proyecto y sus tareas
     * @return
     * @throws Exception 
     */
    @Override
    public String execute() throws Exception {
        // DAOs necesarios para la obtención de instancias desde la persistencia
        ProyectoDAO daoProyecto = new ProyectoDAO();
        TareaDAO daoTarea = new TareaDAO();
        ParticipacionDAO daoParticipacion = new ParticipacionDAO();
        // Definición del proyecto en cuestión
        setProyecto(daoProyecto.getProyecto(getIdProyecto()));
        Map session = (Map) ActionContext.getContext().getSession();
        Persona persona = (Persona) session.get("logged");
        // Verificación de si el usuario logeado es administrador o no
        if (persona.isAdmin()) {
            // Si es administrador, se podrá visaulizar todas las tareas asociadas al proyecto
            setListaTareas(daoTarea.getTareasPorProyecto(getIdProyecto()));
            setListaParticipacion(daoParticipacion.getParticipacionPorProyecto(getIdProyecto()));
        } else {
            // Si no es administrador, solo visualizará las tareas que le han sido asociadas a el/ella
            setListaTareas(daoTarea.getTareasPorProyectoPorPersona(idProyecto, persona.getIdPersona()));
        }
        return SUCCESS;
    }

    /**
     * Método para ir al formulario de edición de proyecto
     * @return 
     */
    public String goToEditarProyecto() {
            ProyectoDAO daoProyecto = new ProyectoDAO();
            setProyecto(daoProyecto.getProyecto(getIdProyecto()));
        return SUCCESS;
    }
    
    public String goToCrearProyecto() {
        return SUCCESS;
    }

    public void validate() {

    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public List<Participacion> getListaParticipacion() {
        return listaParticipacion;
    }

    public void setListaParticipacion(List<Participacion> listaParticipacion) {
        this.listaParticipacion = listaParticipacion;
    }


}

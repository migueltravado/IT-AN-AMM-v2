/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ParticipacionDAO;
import Modelo.DAO.PersonaDAO;
import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Participacion;
import Modelo.POJOs.Persona;
import Modelo.POJOs.Tarea;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleja
 */
public class ModificarTareaAction extends ActionSupport {

    //Para cargar los datos del formulario
    private List<Persona> personas;
    private List<Tarea> tareas;

    private Tarea tarea;

    //Para modificar los datos
    private int idProyecto;
    private int idPersona;
    private int idTareaPredecesora;

    public ModificarTareaAction() {
    }

    public String execute() throws Exception {

        TareaDAO tDAO = new TareaDAO();

        System.out.println(getTarea());

        PersonaDAO personaDAO = new PersonaDAO();

        Persona persona = personaDAO.getPersonaId(getIdPersona());

        ParticipacionDAO pDAO = new ParticipacionDAO();

        Participacion p = pDAO.getParticipacionPersonaProyecto(idProyecto, persona.getIdPersona());

        getTarea().setParticipacion(p);

        tDAO.updateTarea(getTarea());

        //Añadimos a la otra tarea su sucesora
        if (getIdTareaPredecesora() != -1) {

            Tarea t2 = tDAO.getTarea(getIdTareaPredecesora());
            t2.getTareas().add(getTarea());
            tDAO.updateTarea(t2);
        }

        return SUCCESS;
    }

    public String modificar() throws Exception {
        cargaDatos();
        return SUCCESS;
    }

    public void cargaDatos() {
        //OBTENER LOS LISTADOS DE PERSONAS EN EL PROYECTO
        PersonaDAO pDAO = new PersonaDAO();
        this.personas = pDAO.getPersonasPorProyecto(this.idProyecto);

        TareaDAO tDAO = new TareaDAO();

        //OBTENER LOS LISTADOS DE TAREAS EN EL PROYECTO
        setTareas(tDAO.getTareasProyectoModificar(this.idProyecto, this.tarea.getIdTarea()));
        getTareas().remove(this.getTarea());
        Tarea t = new Tarea();
        t.setNombre("Ninguna");
        t.setIdTarea(-1);
        tareas.add(0, t);
    }

    @Override
    public void validate() {
        if (getPersonas() == null) {
            if (getTarea().getNombre() == null || tarea.getNombre().isEmpty()) {
                addFieldError("tarea.nombre", getText("nombre.error"));
            }
            // Comprobación de que las fechas son rellenadas
            // En el caso del formato, se valida de forma interna con Struts2, al 
            // enlazar el campo del formulario con una variable tipo java.util.Date
            if (getTarea().getFechaInicio() == null) {
                addFieldError("tarea.fechaInicio", getText("fechaInicio.error"));
            }
            if (getTarea().getFechaFin() == null) {
                addFieldError("tarea.fechaFin", getText("fechaFin.error"));
            }
            cargaDatos();
        }

    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdTareaPredecesora() {
        return idTareaPredecesora;
    }

    public void setIdTareaPredecesora(int idTareaPredecesora) {
        this.idTareaPredecesora = idTareaPredecesora;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ParticipacionDAO;
import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Participacion;
import Modelo.POJOs.Tarea;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author miguel.travado
 */
public class AdicionTareaAction extends ActionSupport {

    private int idProyecto;
    private Tarea tarea;
    private int idParticipacion;
    private int idTarea;
    private List<Participacion> listaParticipacion;
    private List<Tarea> listaTarea;

    public AdicionTareaAction() {
    }

    public String execute() throws Exception {
        ParticipacionDAO daoParticipacion = new ParticipacionDAO();
        TareaDAO daoTarea = new TareaDAO();
        Tarea t = daoTarea.getTarea(getIdTarea());
        Participacion part = daoParticipacion.getParticipacion(getIdParticipacion());
        getTarea().setTarea(t);
        getTarea().setParticipacion(part);
        daoTarea.saveTarea(getTarea());
        return SUCCESS;
    }

    public void validate() {
        if (tarea.getNombre() == null || tarea.getNombre().isEmpty()) {
            addFieldError("tarea.nombre", "El nombre de la tarea es obligatorio");
        }
        if (tarea.getFechaInicio() == null) {
            addFieldError("tarea.fechaInicio", "La fecha de inicio es obligatoria");
        }
        if (tarea.getFechaFin() == null) {
            addFieldError("tarea.fechaFin", "La fecha de fin es obligatoria");
        }
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public int getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(int idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public List<Participacion> getListaParticipacion() {
        return listaParticipacion;
    }

    public void setListaParticipacion(List<Participacion> listaParticipacion) {
        this.listaParticipacion = listaParticipacion;
    }

    public List<Tarea> getListaTarea() {
        return listaTarea;
    }

    public void setListaTarea(List<Tarea> listaTarea) {
        this.listaTarea = listaTarea;
    }
    
}

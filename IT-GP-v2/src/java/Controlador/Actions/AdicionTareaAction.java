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
    // En este caso, la tarea se crea implicitamente por el paso por parámetros
    // al objeto desde el .jsp, este aspecto lo maneja Struts2
    private Tarea tarea;
    private int idParticipacion;
    private int idTarea;
    private List<Participacion> listaParticipacion;
    private List<Tarea> listaTarea;

    public AdicionTareaAction() {
    }

    /**
     * Método para la adición de una tarea nueva asociada a un proyecto
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        // DAOs necesarios para la búsqueda y guardado de instancias en la BBDD
        ParticipacionDAO daoParticipacion = new ParticipacionDAO();
        TareaDAO daoTarea = new TareaDAO();
        // Obtención de la tarea que precede a la nueva
        Tarea t = null;
        if(idTarea != -1){
            t =daoTarea.getTarea(getIdTarea());
        }
        // Obtención de la participación asociada a la tarea (por ende, ya tiene
        // asociada un proyecto y una persona)
        Participacion part = daoParticipacion.getParticipacion(getIdParticipacion());
        // Asociación de tarea predecesoria y participación
        getTarea().setTarea(t);
        getTarea().setParticipacion(part);
        
        // Guardado de tarea en la BBDD
        daoTarea.saveTarea(getTarea());
        return SUCCESS;
    }

    /**
     * Valicación de la acción
     */
    public void validate() {
        // Comprobación de que el nombre es rellenado
        if (tarea.getNombre() == null || tarea.getNombre().isEmpty()) {
            addFieldError("tarea.nombre", "El nombre de la tarea es obligatorio");
        }
        // Comprobación de que las fechas son rellenadas
        // En el caso del formato, se valida de forma interna con Struts2, al 
        // enlazar el campo del formulario con una variable tipo java.util.Date
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

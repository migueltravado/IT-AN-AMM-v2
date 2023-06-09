/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ProyectoDAO;
import Modelo.POJOs.Proyecto;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.core.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author miguel.travado
 */
public class EditarProyectoAction extends ActionSupport {
    // Asociación interna por struts2 de los parámetros del formulario al 
    // objeto proyecto
    private Proyecto proyecto;

    public EditarProyectoAction() {
    }

    /**
     * Método que actualiza el proyecto en cuestión
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        ProyectoDAO daoProyecto = new ProyectoDAO();
        daoProyecto.updateProyecto(getProyecto());
        return SUCCESS;
    }

    /**
     * Validación de la acción
     */
    @Override
    public void validate(){
        // Mismas comprobaciones que en la creación de un proyecto
        if (proyecto.getNombre() == null || proyecto.getNombre().trim().isEmpty()) {
            addFieldError("proyecto.nombre", "El nombre es obligatorio");
        }
        if (proyecto.getDescripcion() == null || proyecto.getDescripcion().trim().isEmpty()) {
            addFieldError("proyecto.descripcion", "La descripción es obligatoria");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (proyecto.getFechaInicio() == null) {
            addFieldError("proyecto.fechaInicio", "La fecha de inicio es obligatoria");
        }
        if (proyecto.getFechaFin() == null) {
            addFieldError("proyecto.fechaFin", "La fecha de fin es obligatoria");
        }
        if(proyecto.getFechaFin().compareTo(proyecto.getFechaInicio()) < 0){
            addFieldError("proyecto.fechaFin", "La fecha de fin debe ser posterior a la fecha inicio");
        }
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

}

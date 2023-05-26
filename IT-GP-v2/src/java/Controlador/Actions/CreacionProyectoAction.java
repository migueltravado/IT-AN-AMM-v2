/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ProyectoDAO;
import Modelo.POJOs.Proyecto;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;

/**
 *
 * @author miguel.travado
 */
public class CreacionProyectoAction extends ActionSupport {
    // La asociación de parámetros del formulario es directa al objeto (comprobar
    // formulario en el .jsp correspondiente)
    private Proyecto proyecto;
    
    public CreacionProyectoAction() {
    }
    
    /**
     * Método de creación de proyecto exclusivo para administradores
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        // Dado que la asignación de parámetros es directa al objeto, únicamente
        // se almacena la instancia en la BBDD
        ProyectoDAO daoProyecto = new ProyectoDAO();
        daoProyecto.saveProyecto(getProyecto());
        return SUCCESS;
    }

    /**
     * Valicación de la acción
     */
    @Override
    public void validate(){
        // Comprobación de que el nombre no está vacío
        if (proyecto.getNombre() == null || proyecto.getNombre().trim().isEmpty()) {
            addFieldError("proyecto.nombre", "El nombre es obligatorio");
        }
        // Comprobación de que la descripción no está vacío
        if (proyecto.getDescripcion() == null || proyecto.getDescripcion().trim().isEmpty()) {
            addFieldError("proyecto.descripcion", "La descripción es obligatoria");
        }
        // Comprobación de que el nombre no está vacío
        // Al igual que en otras validaciones, el formato de la fecha se valida de forma
        // interna por Struts, al estar asociada con un objeto tipo java.util.Date
        if (proyecto.getFechaInicio() == null) {
            addFieldError("proyecto.fechaInicio", "La fecha de inicio es obligatoria");
        }
        if (proyecto.getFechaFin() == null) {
            addFieldError("proyecto.fechaFin", "La fecha de fin es obligatoria");
        }
        // Comprobación de que la fecha de inicio es anterior a la fecha de finalización
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

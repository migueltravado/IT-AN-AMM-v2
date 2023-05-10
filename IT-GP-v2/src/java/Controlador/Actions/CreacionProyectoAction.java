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
    private Proyecto proyecto;
    
    public CreacionProyectoAction() {
    }
    
    public String execute() throws Exception {
        ProyectoDAO daoProyecto = new ProyectoDAO();
        daoProyecto.saveProyecto(getProyecto());
        return SUCCESS;
    }

    @Override
    public void validate(){
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

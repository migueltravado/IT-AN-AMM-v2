/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Tarea;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author miguel.travado
 */
public class CheckTareaAction extends ActionSupport {
    private int idProyecto;
    private int idTarea;
    private Tarea tarea;
    
    public CheckTareaAction() {
    }
    
    /**
     * Método que modifica el valor del atributo "Completado" de una tarea, mostrando
     * que esa tarea ya se ha realizado
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        // Obtención de la tarea
        TareaDAO daoTarea = new TareaDAO();
        // Modificación del atributo de la tarea
        getTarea().setCompletado(true);
        // Modificación de la actualización en persistencia del sistema
        daoTarea.updateTarea(getTarea());
        return SUCCESS;
    }
    
    /**
     * Validación de la acción
     * Se comprueba que la tarea predecesora de la tarea objetivo está completada
     * Si no es así, salta un error y no permite la actualización de estado de la 
     * tarea objetivo
     */
    public void validate(){
        TareaDAO daoTarea = new TareaDAO();
        setTarea(daoTarea.getTarea(getIdTarea()));
        // Obtención de la tarea predecesora
        Tarea tareaPredecesora = getTarea().getTarea();
        // Es posible que una tarea no tenga otra tarea relacionada
        if(tareaPredecesora != null){
            // Verificación de que la tarea está completada
            if(!tareaPredecesora.isCompletado()){
                // No se muestra el error en el submit de "Check"
                addFieldError("idTarea", "La tarea previa no está completada");
            }
        }
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
    
    
}

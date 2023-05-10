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
    
    public String execute() throws Exception {
        TareaDAO daoTarea = new TareaDAO();
        getTarea().setCompletado(true);
        daoTarea.updateTarea(getTarea());
        return SUCCESS;
    }
    
    public void validate(){
        TareaDAO daoTarea = new TareaDAO();
        setTarea(daoTarea.getTarea(getIdTarea()));
        Tarea tareaPredecesora = getTarea().getTarea();
        if(tareaPredecesora != null){
            if(!tareaPredecesora.isCompletado()){
                // No se muestra el error en el submit de "Check"
                //INTERNACIONALIZAR
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.TareaDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author aleja
 */
public class EliminarTareaAction extends ActionSupport {
    
    private String idTarea;
    
    public EliminarTareaAction() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String eliminar() throws Exception {

        TareaDAO tDAO = new TareaDAO();

        tDAO.deleteTarea(this.idTarea);

        //RECOPILAR TODOS LOS DATOS PARA VOLVER A LA VISTA ANTERIOR
        
        
        
        
        return SUCCESS;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }
    
    
    
    
}

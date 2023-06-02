/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ForoDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.POJOs.Foro;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author aleja
 */
public class CargaForoAdminAction extends ActionSupport {
    
    private List<Foro> foros;
    private int idProyecto;
    
    public CargaForoAdminAction() {
    }
    
    public String execute() throws Exception {
        ForoDAO fDAO = new ForoDAO();
        
        setForos(fDAO.getForosProyecto(getIdProyecto()));
        
        return SUCCESS;        
    }

    public List<Foro> getForos() {
        return foros;
    }

    public void setForos(List<Foro> foros) {
        this.foros = foros;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    

    
    
    
}

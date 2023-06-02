/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ForoDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.POJOs.Foro;
import Modelo.POJOs.Persona;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aleja
 */
public class CargaForoAction extends ActionSupport {
    
    private List<Foro> foros;
    private int idProyecto;
    
    public CargaForoAction() {
    }
    
    public String execute() throws Exception {
        ForoDAO fDAO = new ForoDAO();
        
        Map session = (Map) ActionContext.getContext().getSession();
        Persona persona = (Persona)session.get("logged");
        
        // Verificación de si la persona es admin o no
        if(persona.isAdmin()){
            // Si la persona es administradora, se le muestran todos los foros existentes
            setForos(fDAO.getForosAdmin());
        }
        else{
            // Si la persona no es administradora, se le mostrarán solo los foros
            // en los que participe
            setForos(fDAO.getForosPerona(persona.getIdPersona()));
        }
        
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

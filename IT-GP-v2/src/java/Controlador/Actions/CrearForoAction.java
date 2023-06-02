/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ForoDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.POJOs.Foro;
import Modelo.POJOs.Proyecto;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author aleja
 */
public class CrearForoAction extends ActionSupport {
    
    private int idProyecto;
    private String descripcion;
    
    public CrearForoAction() {
    }
    
    public String execute() throws Exception {
        ForoDAO fDAO = new ForoDAO();
        ProyectoDAO pDAO = new ProyectoDAO();
        
        Proyecto p = pDAO.getProyecto(getIdProyecto());
        
        Foro f = new Foro(p);
        
        f.setDescripcion(getDescripcion());
        
        fDAO.crearForo(f);
        
        
        p.setForo(f);
        
        pDAO.updateProyecto(p);
        
        return SUCCESS;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

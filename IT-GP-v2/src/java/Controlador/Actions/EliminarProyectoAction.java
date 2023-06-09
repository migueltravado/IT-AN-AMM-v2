/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ProyectoDAO;
import Modelo.POJOs.Proyecto;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author miguel.travado
 */
public class EliminarProyectoAction extends ActionSupport {
    private int idProyecto;
    private Proyecto proyecto;
    
    public EliminarProyectoAction() {
    }
    
    /**
     * Método para la eliminación de un proyecto
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        ProyectoDAO daoProyecto = new ProyectoDAO();
        // Obtención de la instancia proyecto
        setProyecto(daoProyecto.getProyecto(idProyecto));
        // Eliminación del proyecto en la persistencia
        daoProyecto.deleteProyecto(getProyecto());
        return SUCCESS;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    
    
}

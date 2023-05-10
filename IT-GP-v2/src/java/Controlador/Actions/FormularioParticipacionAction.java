/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.RolDAO;
import Modelo.POJOs.Rol;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author miguel.travado
 */
public class FormularioParticipacionAction extends ActionSupport {
    private int idPersona;
    private int idProyecto;
    private List<Rol> listaRol;
    
    public FormularioParticipacionAction() {
    }
    
    public String execute() throws Exception {
        RolDAO daoRol = new RolDAO();
        setListaRol(daoRol.getRoles());
        return SUCCESS;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }
    
    
    
}

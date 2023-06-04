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
 * @author aleja
 */
public class CargaRoles extends ActionSupport {
    
    private List<Rol> roles;
    
    public CargaRoles() {
    }
    
    public String execute() throws Exception {
        RolDAO rolDAO = new RolDAO();
        setRoles(rolDAO.getRoles());
        return SUCCESS;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
    
    
}

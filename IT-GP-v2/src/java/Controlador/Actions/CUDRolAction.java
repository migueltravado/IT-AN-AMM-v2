/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.RolDAO;
import Modelo.POJOs.Rol;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author aleja
 */
public class CUDRolAction extends ActionSupport {
    
    private Rol rol;
    private int idRol;
    
    public CUDRolAction() {
    }
    
    //AQUI HACEMOS EL MODIFICARROL
    public String execute() throws Exception {
        RolDAO rolDAO = new RolDAO();
        setRol(rolDAO.getRol(getIdRol()));
        return SUCCESS;
    }
    
    //ESTO ES MODROL
    public String modificar() throws Exception{
        RolDAO rolDAO = new RolDAO();
        rolDAO.modificarRol(getRol());
        return SUCCESS;
    }
    
    public String addRol() throws Exception{
        RolDAO rolDAO = new RolDAO();
        rolDAO.crearRol(getRol());
        return SUCCESS;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    
    
}

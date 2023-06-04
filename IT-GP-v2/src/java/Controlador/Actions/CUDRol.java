/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.POJOs.Rol;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author aleja
 */
public class CUDRol extends ActionSupport {
    
    private Rol rol;
    private int idRol;
    
    public CUDRol() {
    }
    
    //AQUI HACEMOS EL MODIFICARROL
    public String execute() throws Exception {
        
        return SUCCESS;
    }
    
    //ESTO ES MODROL
    public String modificar() throws Exception{
        return SUCCESS;
    }
    
    public String eliminar() throws Exception{
        return SUCCESS;
    }
    
    public String addRol() throws Exception{
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

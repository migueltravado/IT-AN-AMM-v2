/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.MensajeDAO;
import Modelo.POJOs.Mensaje;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author aleja
 */
public class CargaMensajesAction extends ActionSupport {
    
    private int idForo;
    private List<Mensaje> mensajes;
    
    
    public CargaMensajesAction() {
    }
    
    public String execute() throws Exception {
        MensajeDAO mDAO = new MensajeDAO();
        
        setMensajes(mDAO.getMensajesForo(getIdForo()));
        
        return SUCCESS;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
}

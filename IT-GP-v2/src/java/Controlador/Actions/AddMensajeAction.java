/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.EnvioDAO;
import Modelo.DAO.ForoDAO;
import Modelo.DAO.MensajeDAO;
import Modelo.POJOs.Envio;
import Modelo.POJOs.Mensaje;
import Modelo.POJOs.Persona;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aleja
 */
public class AddMensajeAction extends ActionSupport {
    
    private int idForo;
    private Mensaje mensaje;
    private List<Mensaje> mensajes;
    
    public AddMensajeAction() {
    }
    
    public String execute() throws Exception {
        
        //Recuperamos la session para ver que id tiene la persona que quiere mandar el mensaje
        Map session = (Map) ActionContext.getContext().getSession();
        Persona persona = (Persona)session.get("logged");
        int idPersona = (persona).getIdPersona();
        
        EnvioDAO eDAO = new EnvioDAO();
        MensajeDAO mDAO = new MensajeDAO();
        
        Envio e = eDAO.getEnvio(idPersona, getIdForo());
        
        //Si no ha mandado ningun mensaje todavia, crea una entidad envío
        if(e == null){
            ForoDAO fDAO = new ForoDAO();
            e = new Envio();
            
            e.setPersona(persona);
            e.setForo(fDAO.getForo(getIdForo()));
            eDAO.addEnvio(e);
        }
        getMensaje().setEnvio(e);
        mDAO.addMensaje(getMensaje());
        
        return SUCCESS;
    }
    
    private void cargaMensajes(){
        MensajeDAO mDAO = new MensajeDAO();
        
        setMensajes(mDAO.getMensajesForo(getIdForo()));
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    
}

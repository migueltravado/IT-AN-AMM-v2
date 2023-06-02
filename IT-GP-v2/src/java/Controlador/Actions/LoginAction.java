/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.POJOs.Persona;
import Modelo.DAO.PersonaDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author miguel.travado
 */
public class LoginAction extends ActionSupport {
    private Persona persona;
    
    public LoginAction() {
    }
    
    /**
     * Método que guarda una variable en sesión con la persona que se ha conseguido
     * loggear en el sistema.
     * @return
     * @throws Exception 
     */
    @Override
    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().getSession();
        session.put("logged", persona);
        return SUCCESS;
    }
    
    /**
     * Validación de la acción
     */
    @Override
    public void validate(){
        String password = getPersona().getPassword();
        PersonaDAO dao = new PersonaDAO();
        setPersona(dao.getPersona(persona.getUsuario()));
        // Comprobación de que el usuario existe
        if(getPersona() == null){
            addFieldError("persona.usuario", getText("persona.usuario.error"));
            return;
        }
        // Comprobación de que la contraseña coincide
        if(!getPersona().getPassword().equals(password)){
            addFieldError("persona.password", getText("persona.password.error"));
            return;
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}

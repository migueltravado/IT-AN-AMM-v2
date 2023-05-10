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
    
    @Override
    public String execute() throws Exception {
        System.out.println("----------------------\n");
        Map session = (Map) ActionContext.getContext().getSession();
        System.out.println("----------------------\n");
        session.put("logged", persona);
        System.out.println("----------------------\n");
        return SUCCESS;
    }
    
    @Override
    public void validate(){
        String password = getPersona().getPassword();
        PersonaDAO dao = new PersonaDAO();
        setPersona(dao.getPersona(persona.getUsuario()));
        if(getPersona() == null){
            addFieldError("persona.usuario", "Usuario inexistente");
            return;
        }
        if(!getPersona().getPassword().equals(password)){
            addFieldError("persona.password", "Contraseña incorrecta");
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

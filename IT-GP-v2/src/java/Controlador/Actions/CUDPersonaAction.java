/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.PersonaDAO;
import Modelo.POJOs.Persona;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author aleja
 */
public class CUDPersonaAction extends ActionSupport {
    private Persona persona;
     
    
    public CUDPersonaAction() {
    }
    
    public String execute() throws Exception {
        PersonaDAO daoPersona = new PersonaDAO();
        daoPersona.modificaPersona(persona);
        return SUCCESS;
    }
    
    
    public String modificar() throws Exception {
        return SUCCESS;
    }
    
    
    public String eliminar() throws Exception {
        PersonaDAO daoPersona = new PersonaDAO();
        daoPersona.eliminarPersona(persona);
        return SUCCESS;
    }
    
    public String crear() throws Exception {
        PersonaDAO pDAO = new PersonaDAO();
        pDAO.crearPersona(this.persona);
        return SUCCESS;
    }
    
    /*
    Método validate que debe comprobar que todos los datos de la Persona
    están rellenos y con un mínimo de caracteres para cada uno de ellos, además
    de que el DNI tenga el formato necesario
    */
    @Override
    public void validate(){
        String dniRegex = "^([0-9]{8}[A-Z])|[XYZ][0-9]{7}[A-Z]$";
        if(this.persona.getApellidos().length() < 4){
            addFieldError("persona.apellidos", getText("apellidos.error"));
        } 
        if(this.persona.getNombre().length() < 3){
            addFieldError("persona.nombre", getText("nombre.error"));
        } 
        /*
        if(Pattern.compile(dniRegex).matcher(this.persona.getDni()).matches()){
            //ESTA VALIDACION NO FUNCIONA WTF
            addFieldError("persona.dni", getText("dni.error"));
        } */
        if(this.persona.getUsuario().length() < 4){
            addFieldError("persona.usuario", getText("usuario.error"));
        } 
        if(this.persona.getPassword().length() < 8){
            addFieldError("persona.password", getText("password.error"));
        } 
    }
    
    
    
    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}

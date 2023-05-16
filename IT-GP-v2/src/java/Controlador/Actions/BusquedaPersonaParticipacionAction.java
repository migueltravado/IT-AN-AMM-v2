/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.PersonaDAO;
import Modelo.POJOs.Participacion;
import Modelo.POJOs.Persona;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miguel.travado
 */
public class BusquedaPersonaParticipacionAction extends ActionSupport {

    private int idProyecto;
    private int idPersona;
    private Persona persona;
    private List<Persona> listaPersona;

    public BusquedaPersonaParticipacionAction() {
    }

    public String execute() throws Exception {
        setListaPersona(new ArrayList<>());
        if (getPersona() != null) {
            getListaPersona().add(persona);
        }
        return SUCCESS;
    }

    public void validate() {
        PersonaDAO daoPersona = new PersonaDAO();
        setPersona(daoPersona.getPersonaId(idPersona));
        if (getPersona() != null) {
            if (getPersona().isAdmin()) {
                //INTERNACIONALIZAR
                addFieldError("idPersona", "La persona no puede ser un administrador");
            }
            // AÑADIR VALIDACIÓN PARA QUE NO BUSQUE UNA PERSONA QUE YA ESTÉ 
            // COMO PARTICIPANTE EN EL PROYECTO 
        }
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

}

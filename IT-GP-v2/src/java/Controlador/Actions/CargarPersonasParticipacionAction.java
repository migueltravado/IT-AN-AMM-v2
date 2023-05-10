/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.PersonaDAO;
import Modelo.POJOs.Persona;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author miguel.travado
 */
public class CargarPersonasParticipacionAction extends ActionSupport {
    private List<Persona> listaPersona;
    private int idProyecto;
    
    public CargarPersonasParticipacionAction() {
    }
    
    public String execute() throws Exception {
        PersonaDAO daoPersona = new PersonaDAO();
        setListaPersona(daoPersona.getPersonasPorProyectoNotExist(getIdProyecto()));
        return SUCCESS;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
    
}

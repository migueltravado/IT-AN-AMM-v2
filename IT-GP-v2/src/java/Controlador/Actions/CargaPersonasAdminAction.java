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
public class CargaPersonasAdminAction extends ActionSupport {
    private List<Persona> listaPersonas;
    
    public CargaPersonasAdminAction() {
    }
    
    /**
     * Método que carga un listado de personas para su visualización (exclusivo
     * de admin)
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        PersonaDAO daoPersona = new PersonaDAO();
        setListaPersonas(daoPersona.getPersonas());
        return SUCCESS;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
}

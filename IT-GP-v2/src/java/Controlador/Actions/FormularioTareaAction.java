/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.PersonaDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.DAO.TareaDAO;
import Modelo.POJOs.Participacion;
import Modelo.POJOs.Proyecto;
import Modelo.POJOs.Tarea;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Set;

/**
 *
 * @author miguel.travado
 */
public class FormularioTareaAction extends ActionSupport {
    private int idProyecto;
    private Set<Participacion> listaParticipacion;
    private List<Tarea> listaTarea;
    
    public FormularioTareaAction() {
    }
    
    public String execute() throws Exception {
        ProyectoDAO daoProyecto = new ProyectoDAO();
        TareaDAO daoTarea = new TareaDAO();
        Proyecto p = daoProyecto.getProyecto(getIdProyecto());
        setListaParticipacion(p.getParticipacions());
        setListaTarea(daoTarea.getTareasPorProyecto(getIdProyecto()));
        return SUCCESS;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Set<Participacion> getListaParticipacion() {
        return listaParticipacion;
    }

    public void setListaParticipacion(Set<Participacion> listaParticipacion) {
        this.listaParticipacion = listaParticipacion;
    }

    public List<Tarea> getListaTarea() {
        return listaTarea;
    }

    public void setListaTarea(List<Tarea> listaTarea) {
        this.listaTarea = listaTarea;
    }

    

    
}

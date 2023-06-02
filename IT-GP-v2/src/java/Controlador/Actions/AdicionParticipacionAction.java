/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Actions;

import Modelo.DAO.ParticipacionDAO;
import Modelo.DAO.PersonaDAO;
import Modelo.DAO.ProyectoDAO;
import Modelo.DAO.RolDAO;
import Modelo.POJOs.Participacion;
import Modelo.POJOs.Persona;
import Modelo.POJOs.Proyecto;
import Modelo.POJOs.Rol;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author miguel.travado
 */
public class AdicionParticipacionAction extends ActionSupport {
    private List<Rol> listaRol;
    private int idProyecto;
    private int idPersona;
    private int iddRol;
    private int cuota;
    
    public AdicionParticipacionAction() {
    }
    
    /**
     * Método que realiza la búsqueda de proyecto, persona y rol asociados
     * a la participación que se desea crear.
     * @return
     * @throws Exception 
     */
    public String execute() throws Exception {
        // DAOs necesarios para la búsqueda y el guardado de una nueva instancia
        ProyectoDAO daoProyecto = new ProyectoDAO();
        PersonaDAO daoPersona = new PersonaDAO();
        RolDAO daoRol = new RolDAO();
        ParticipacionDAO daoParticipacion = new ParticipacionDAO();
        // Búsqueda de el proyecto, persona y rol según su ID
        Proyecto pro = daoProyecto.getProyecto(idProyecto);
        Persona pers = daoPersona.getPersonaId(idPersona);
        Rol rol = daoRol.getRol(iddRol);
        // Creación de la isntancia participación
        Participacion participacion = new Participacion(pers, pro, rol, cuota);
        // Acceso a la BBDD para guardar la instancia mediante el DAO
        daoParticipacion.saveParticipacion(participacion);
        return SUCCESS;
    }
    
    /**
     * Validación de la acción
     */
    public void validate(){
        // En caso de que la validación pueda fallar, se obtiene la lista de
        // roles para la impresión (select) en la página web del formulario
        // si se devolviese input. Si no se hiciese este paso, daría ERROR
        RolDAO daoRol = new RolDAO();
        setListaRol(daoRol.getRoles());
        // Comprobación de que la cuota por participación en el proyecto es 
        // mayor estricto que 0.
        if (getCuota() <= 0) {
            addFieldError("cuota", getText("cuota.error"));
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

    public int getIddRol() {
        return iddRol;
    }

    public void setIddRol(int idRol) {
        this.iddRol = idRol;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }
    
}

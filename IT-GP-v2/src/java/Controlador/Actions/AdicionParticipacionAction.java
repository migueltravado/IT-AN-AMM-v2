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
    
    public String execute() throws Exception {
        ProyectoDAO daoProyecto = new ProyectoDAO();
        PersonaDAO daoPersona = new PersonaDAO();
        RolDAO daoRol = new RolDAO();
        ParticipacionDAO daoParticipacion = new ParticipacionDAO();
        Proyecto pro = daoProyecto.getProyecto(idProyecto);
        Persona pers = daoPersona.getPersonaId(idPersona);
        Rol rol = daoRol.getRol(iddRol);
        Participacion participacion = new Participacion(pers, pro, rol, cuota);
        daoParticipacion.saveParticipacion(participacion);
        return SUCCESS;
    }
    
    public void validate(){
        RolDAO daoRol = new RolDAO();
        System.out.println(":::::: " + getIddRol());
        setListaRol(daoRol.getRoles());
        if (cuota <= 0) {
            addFieldError("cuota", "La cuota debe ser un número positivo mayor que 0.");
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

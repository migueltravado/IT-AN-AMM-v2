package Modelo.POJOs;
// Generated 09-may-2023 5:43:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Participacion generated by hbm2java
 */
public class Participacion  implements java.io.Serializable {


     private Integer idParticipacion;
     private Persona persona;
     private Proyecto proyecto;
     private Rol rol;
     private int cuota;
     private Set tareas = new HashSet(0);

    public Participacion() {
    }

	
    public Participacion(Persona persona, Proyecto proyecto, Rol rol, int cuota) {
        this.persona = persona;
        this.proyecto = proyecto;
        this.rol = rol;
        this.cuota = cuota;
    }
    public Participacion(Persona persona, Proyecto proyecto, Rol rol, int cuota, Set tareas) {
       this.persona = persona;
       this.proyecto = proyecto;
       this.rol = rol;
       this.cuota = cuota;
       this.tareas = tareas;
    }
   
    public Integer getIdParticipacion() {
        return this.idParticipacion;
    }
    
    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Proyecto getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    public Rol getRol() {
        return this.rol;
    }
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public int getCuota() {
        return this.cuota;
    }
    
    public void setCuota(int cuota) {
        this.cuota = cuota;
    }
    public Set getTareas() {
        return this.tareas;
    }
    
    public void setTareas(Set tareas) {
        this.tareas = tareas;
    }




}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;
import Modelo.POJOs.Persona;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author miguel.travado
 */
public class PersonaDAO {
    public Persona getPersona(String usuario){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Persona where usuario = '" + usuario + "'");
        Persona persona = (Persona)q1.uniqueResult();
        tx.commit();
        return persona;
    }
    
    public Persona getPersonaId(int idPersona){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Persona where idPersona = " + idPersona);
        Persona persona = (Persona)q1.uniqueResult();
        tx.commit();
        return persona;
    }
    
    public List<Persona> getPersonas(){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Persona");
        List<Persona> listaPersona = (List<Persona>)q1.list();
        tx.commit();
        return listaPersona;
    }
    
    public List<Persona> getPersonasNoAdmin(){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select p From Persona p where p.admin = false");
        List<Persona> listaPersona = (List<Persona>)q1.list();
        tx.commit();
        return listaPersona;
    }
    
    public List<Persona> getPersonasPorProyecto(int idProyecto){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select p From Persona p JOIN p.participacions par JOIN par.proyecto pro WHERE pro.idProyecto = " + idProyecto);
        List<Persona> listaPersona = (List<Persona>)q1.list();
        tx.commit();
        return listaPersona;
    }
    
    public List<Persona> getPersonasPorProyectoNotExist(int idProyecto){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("SELECT p FROM Persona p" + " WHERE NOT EXISTS " + "(SELECT par FROM p.participacions par WHERE par.proyecto.idProyecto = " + idProyecto + ") and admin != true");
        List<Persona> listaPersona = (List<Persona>)q1.list();
        tx.commit();
        return listaPersona;
    }
}

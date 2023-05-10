/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;
import Modelo.POJOs.Proyecto;
import java.util.*;
import org.hibernate.*;

/**
 *
 * @author miguel.travado
 */
public class ProyectoDAO {
    public Proyecto getProyecto(int idProyecto){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Proyecto WHERE idProyecto = " + idProyecto);
        Proyecto p = (Proyecto)q1.uniqueResult();
        tx.commit();
        return p;
    }
    
    public List<Proyecto> getProyectos(){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Proyecto");
        List<Proyecto> listaProyectos = (List<Proyecto>)q1.list();
        tx.commit();
        return listaProyectos;
    }
    
    public List<Proyecto> getProyectosPorPersona(int IdPersona){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select p FROM Proyecto p JOIN p.participacions par JOIN par.persona per WHERE per.idPersona = " + IdPersona);
        List<Proyecto> listaProyectos = (List<Proyecto>)q1.list();
        tx.commit();
        return listaProyectos;
    }
    
    public void deleteProyecto(Proyecto proyecto){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(proyecto);
        tx.commit();
        return;
    }
    
    public void updateProyecto(Proyecto proyecto){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(proyecto);
        tx.commit();
        return;
    }
    
    public void saveProyecto(Proyecto proyecto){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(proyecto);
        tx.commit();
        return;
    }
}

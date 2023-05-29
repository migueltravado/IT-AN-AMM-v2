/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.POJOs.Tarea;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel.travado
 */
public class TareaDAO {
    public List<Tarea> getTareasPorPersona(int idPersona){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select t FROM Tarea t JOIN t.participacion par JOIN par.persona pers WHERE pers.idPersona = " + idPersona);
        List<Tarea> listaProyectos = (List<Tarea>)q1.list();
        tx.commit();
        return listaProyectos;
    }
    
    public List<Tarea> getTareasPorProyectoPorPersona(int idProyecto, int idPersona){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select t FROM Tarea t JOIN t.participacion par JOIN par.proyecto pro JOIN par.persona pers WHERE pro.idProyecto = " + idProyecto + "AND pers.idPersona = " + idPersona);
        List<Tarea> listaProyectos = (List<Tarea>)q1.list();
        tx.commit();
        return listaProyectos;
    }
    
    public List<Tarea> getTareasPorProyecto(int idProyecto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select t FROM Tarea t JOIN t.participacion par JOIN par.proyecto pro WHERE pro.idProyecto = " + idProyecto);
        List<Tarea> listaProyectos = (List<Tarea>)q1.list();
        tx.commit();
        return listaProyectos;
    }
    
    public List<Tarea> getTareasProyectoModificar(int idProyecto, int idTarea){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select t FROM Tarea t JOIN t.participacion par JOIN par.proyecto pro WHERE pro.idProyecto = " + idProyecto + " AND t.idTarea != " + idTarea);
        List<Tarea> listaProyectos = (List<Tarea>)q1.list();
        tx.commit();
        return listaProyectos;
    }
    
    public Tarea getTarea(int idTarea){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select t FROM Tarea t where idTarea = " + idTarea);
        Tarea tarea = (Tarea)q1.uniqueResult();
        tx.commit();
        return tarea;
    }
    
    public void saveTarea(Tarea tarea){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(tarea);
        tx.commit();
    }
    
    public void updateTarea(Tarea tarea){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(tarea);
        tx.commit();
    }
    
    public void deleteTarea(String idTarea){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Tarea WHERE id = " + idTarea);
        Tarea tarea = (Tarea) q.uniqueResult();
        session.delete(tarea);
        tx.commit();
    }
}

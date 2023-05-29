/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.POJOs.Participacion;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel.travado
 */
public class ParticipacionDAO {
    public void saveParticipacion(Participacion participacion){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(participacion);
        tx.commit();
    }
    
    public Participacion getParticipacion(int idParticipacion){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Participacion where idParticipacion = " + idParticipacion);
        Participacion p = (Participacion)q1.uniqueResult();
        tx.commit();
        return p;
    }
    
    public List<Participacion> getParticipacionPorProyecto(int idProyecto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("select p From Participacion p JOIN p.proyecto pro WHERE pro.idProyecto = " + idProyecto);
        List<Participacion> listaParticipacion = (List<Participacion>)q1.list();
        tx.commit();
        return listaParticipacion;
    }
    
    public Participacion getParticipacionPersonaProyecto(int idProyecto, int idPersona){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Participacion where idProyecto = " + idProyecto + " AND idPersona = " + idPersona);
        Participacion p = (Participacion)q1.uniqueResult();
        tx.commit();
        return p;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.POJOs.Foro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author aleja
 */
public class ForoDAO {
    
    public List<Foro> getForosAdmin(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Foro");
        List<Foro> listaForo = (List<Foro>)q1.list();
        tx.commit();
        
        return listaForo;
    }
    
    public List<Foro> getForosProyecto(int idProyecto){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Foro WHERE idProyecto=" + idProyecto);
        List<Foro> listaForo = (List<Foro>)q1.list();
        tx.commit();
        
        return listaForo;
    }
    
    public List<Foro> getForosPerona(int idPersona){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("SELECT f FROM Foro f JOIN f.proyecto p WHERE p.idProyecto IN (SELECT p.idProyecto FROM Proyecto p JOIN p.participacions par JOIN par.persona per WHERE per.idPersona =" + idPersona + ")");
        List<Foro> listaForo = (List<Foro>)q1.list();
        tx.commit();
        
        return listaForo;
        
        
    }
    
}
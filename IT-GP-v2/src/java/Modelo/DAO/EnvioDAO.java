/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.POJOs.Envio;
import Modelo.POJOs.Mensaje;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aleja
 */
public class EnvioDAO {
    
    public void addEnvio(Envio e){
     Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(e);
        tx.commit();   
    }
    
    public Envio getEnvio(int idPersona, int idForo){
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("FROM Envio WHERE idForo = " + idForo + " idPersona = " + idPersona);
        Envio envio = (Envio) q1.uniqueResult();
        tx.commit();
        
        return envio;
    }
    
}

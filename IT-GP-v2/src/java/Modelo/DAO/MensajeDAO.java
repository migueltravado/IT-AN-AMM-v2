/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.POJOs.Mensaje;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author aleja
 */
public class MensajeDAO {
    
    public List<Mensaje> getMensajesForo(int idForo){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("SELECT m FROM Mensaje m JOIN m.envio e WHERE e.foro.idForo = " + idForo);
        List<Mensaje> listaForo = (List<Mensaje>)q1.list();
        tx.commit();
        
        return listaForo;
    }
    
}

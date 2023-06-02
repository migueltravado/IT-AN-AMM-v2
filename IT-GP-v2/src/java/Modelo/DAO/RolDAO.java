/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.POJOs.Persona;
import Modelo.POJOs.Rol;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel.travado
 */
public class RolDAO {
    public List<Rol> getRoles(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Rol");
        List<Rol> listaRol = (List<Rol>)q1.list();
        tx.commit();
        return listaRol;
    }
    
    public Rol getRol(int idRol){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("From Rol where idRol = " + idRol);
        Rol rol = (Rol)q1.uniqueResult();
        tx.commit();
        return rol;
    }
}

package com.tecmm.proyectosocket.db.controller;
import com.tecmm.proyectosocket.db.model.*; 
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author luiscobian
 */
public class DaoPersonas {
    
    // agregar 
    
    public boolean addPersona(Personas persona)
    {
        boolean res = true;
        try{
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("socket_PU");
            EntityManager em = factory.createEntityManager(); 
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            em.close(); 
            factory.close();
        }catch(Exception e){
            res = false; 
            System.out.println("Ocurrio un error al grabar");
            e.printStackTrace();
        }
        return res; 
    }
    
    // consultar 
    public List<Personas> getTodos(){
        List<Personas> datos = null; 
        
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("socket_PU");
            EntityManager em = factory.createEntityManager(); 
            Query q = em.createQuery("SELECT p FROM Personas p"); 
            datos  = q.getResultList();
            em.close();
            factory.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return datos; 
    }
    
}

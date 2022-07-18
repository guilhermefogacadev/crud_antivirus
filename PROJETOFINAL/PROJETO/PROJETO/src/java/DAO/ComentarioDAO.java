/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Comentario;
import Entidades.Usuario;
import Entidades.Virus;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author guilh
 */
public class ComentarioDAO {
     public void Cadastra(Comentario comentario){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(comentario);
        em.getTransaction().commit();
        em.close();
     
        
    }
     public boolean remove(int id){
          EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
          
          EntityManager em= factory.createEntityManager();
          Comentario comentario= (Comentario) em.find(Comentario.class, id);
          em.getTransaction().begin();
          em.remove(comentario);
          em.getTransaction().commit();
          em.close();
          return true;
}
}

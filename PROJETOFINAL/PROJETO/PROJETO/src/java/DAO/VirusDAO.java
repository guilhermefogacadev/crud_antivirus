/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Comentario;
import Entidades.Usuario;
import Entidades.Virus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author guilh
 */
public class VirusDAO {
     public void CadastraVirus(Virus v){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
        em.close();
        
    }
     public ArrayList ListaVirus(){
         EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Virus> query = em.createQuery("SELECT v FROM Virus v",
                Virus.class);
       
         ArrayList<Virus> listados=null;
         
        
        try {
            listados = (ArrayList<Virus>) query.getResultList();
            
        } catch (NoResultException e) {
            listados = null;
        } 
           
        return listados;
     }
     public Virus busca(int id){
         EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Virus> query = em.createQuery("SELECT v FROM Virus v Where v.id=:id",
                Virus.class);
        query.setParameter("id",id);
        
        
        Virus v=null;
         
        
        try {
            v=query.getSingleResult();
            return v;
            
        } catch (NoResultException e) {
            v = null;
        } 
         return v;
        
     }
     public ArrayList buscaComentario(int id){
         EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Comentario> query = em.createQuery("SELECT v FROM Comentario v Where v.virus.id=:id ",
                Comentario.class);
        query.setParameter("id",id);

        
        
        ArrayList<Comentario>comentario;
         
        
        try {
            comentario= (ArrayList) query.getResultList();
           return comentario;
            
            
        } catch (NoResultException e) {
            comentario = null;
        } 
         return comentario;
        
     }
     
      public boolean alterar(Virus virus){
         EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
         
         
        EntityManager em= factory.createEntityManager();
        em.getTransaction().begin();
        em.merge(virus);
        em.getTransaction().commit();
        
        em.close();
        return true;
      }
      
      public boolean verificaUpdate(Virus virus){
           EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Virus> query = em.createQuery("SELECT v FROM Virus v Where v.id=:id AND v.detalhes=:detalhes AND v.nome=:nome AND v.tipo=:tipo",
                Virus.class);
        query.setParameter("id",virus.getId());
        query.setParameter("detalhes",virus.getDetalhes());
        query.setParameter("nome",virus.getNome());
        query.setParameter("tipo",virus.getNome());
 
        
        Virus v=null;
         
        
        try {
        v=query.getSingleResult();
        em.getTransaction().begin();
        em.merge(virus);
        em.getTransaction().commit();
        
        em.close();
            return true;
        } catch (NoResultException e) {
            v = null;
        } 
         return false;
      }

      
      public boolean remove(int id){
          EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
          
          EntityManager em= factory.createEntityManager();
          Virus cadastrada= (Virus) em.find(Virus.class, id);
          em.getTransaction().begin();
          em.remove(cadastrada);
          em.getTransaction().commit();
          em.close();
          return true;
          
      }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author guilh
 */
public class UsuarioDAO  {
    public void CadastraUsuario(Usuario u){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        
    }
    public Usuario Loga(Usuario usuario){
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha ",
                Usuario.class);
        query.setParameter("nome", usuario.getNome());
        query.setParameter("senha",usuario.getSenha());      
        Usuario u = null;
        
        try {
            u = query.getSingleResult();
            return u;
        } catch (NoResultException e) {
            u = null;
        } finally {
        }
        return u;
       
    }

   public boolean verificaCadastro(String nome){
       EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome ",
                Usuario.class);
        query.setParameter("nome", nome); 
        Usuario u = null;
        
        try {
            u = query.getSingleResult();
            return false;
        } catch (NoResultException e) {
            u = null;
        } finally {
        }
        return true;

   }
   public Boolean verificaAdmin(Usuario usuario){
       EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome  And u.admin=true And u.senha=:senha",
                Usuario.class);
         query.setParameter("nome", usuario.getNome());
         query.setParameter("senha", usuario.getSenha());
         
         
        Usuario u = null;
        
        try {
            u = query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            u = null;
        } finally {
        }
        return false;

   }
   
   public Usuario verificaId(int id){
       EntityManagerFactory factory= Persistence.createEntityManagerFactory("sistema_virus");
        
        EntityManager em= factory.createEntityManager();
        Usuario u = (Usuario) em.find(Usuario.class, id);
        return u;
   }
}


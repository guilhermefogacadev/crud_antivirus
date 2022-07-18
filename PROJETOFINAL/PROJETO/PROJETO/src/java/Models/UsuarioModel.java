/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.UsuarioDAO;
import Entidades.Usuario;
import Entidades.Virus;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class UsuarioModel {
    
    
    
    
    
    
    
    
    
    
    
    
     /*static ArrayList<Usuario> usuarios = new ArrayList();
    
    
    
    
    public boolean adicionarUsuario(Usuario u){
        for (Usuario usu: usuarios) {
            if (u.getNome().equals(usu.getNome())) {
                return false;
            }
        }
        
        
        if (usuarios.size() == 0) {
            u.setId(1);
        }
        else{            
            u.setId(usuarios.get(usuarios.size() - 1).getId() + 1);
        }
        
        usuarios.add(u);
        
        
        
                                                                 
                         
        return true;
    }
    
    public boolean alterarUsuario(Usuario u){
        for (Usuario usu : usuarios) {
            if (u.getNome().equals(usu.getNome()) && u.getId() != usu.getId()) {
                return false;
            }
        }
        
        for (Usuario usu : usuarios) {
            if (usu.getId() == u.getId()) {
                usu.setNome(u.getNome());
                usu.setId(u.getId());
                break;
            }
        }
        
        return true;
    }
    */ public Boolean verificaCadastra(Usuario u){
            if (u.getNome().length()==0 || u.getSenha().isEmpty() || u.getCsenha().isEmpty() ) {
                return false;           
            }else if(u.getNome().length()>0 || u.getSenha()!=null|| u.getCsenha()!=null ) {
                UsuarioDAO dao= new UsuarioDAO();
                if(dao.verificaCadastro(u.getNome())==false){
                     return false;
                }else{
                     dao.CadastraUsuario(u);
                    return true;
                }
            }else{
                return false;
            }
     }
    public Usuario verificaLoga(Usuario usuario){
            if (usuario.getNome().isEmpty() ||usuario.getSenha().isEmpty() ) {
                return null;           
            }else{
                UsuarioDAO dao= new UsuarioDAO();
                return dao.Loga(usuario);
                   
            }
     }
    
    public Boolean verficaAdmin(Usuario usuario){
        UsuarioDAO dao= new UsuarioDAO();
        if ( dao.verificaAdmin(usuario)==false) {
                return false;           
            }else
                return true;
            }
    
    public Usuario verificaId(int id){
        UsuarioDAO dao= new UsuarioDAO();
        return dao.verificaId(id);
    
    }
}
    

  /*
    public Usuario getUsuario(int id){
        for (Usuario usu : usuarios) {
            if (usu.getId() == id) {
                return usu;
            }
        }
        return null;
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    */
    
    


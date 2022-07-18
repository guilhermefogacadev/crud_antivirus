/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.ComentarioDAO;
import DAO.UsuarioDAO;
import DAO.VirusDAO;
import Entidades.Comentario;

/**
 *
 * @author guilh
 */
public class ComentarioModel {
    public Boolean Cadastrar(Comentario comentario){
        ComentarioDAO dao= new ComentarioDAO();
         dao.Cadastra(comentario);
         return true;
        
                
    }
    public boolean remove(int id){
        ComentarioDAO dao=new ComentarioDAO();
        if(dao.remove(id)){
            return true;
        }else{
            return false;
        }
    }
}

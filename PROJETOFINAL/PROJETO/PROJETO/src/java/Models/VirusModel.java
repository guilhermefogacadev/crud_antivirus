/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.VirusDAO;
import Entidades.Comentario;
import Entidades.Virus;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author guilh
 */
public class VirusModel {
    
    public Boolean verificaVirus(Virus v){
            if (v.getNome().length()==0 || v.getDetalhes().isEmpty() || "Sim".equals(v.getTipo())) {
                return false;           
            }else{
                VirusDAO dao= new VirusDAO();
                dao.CadastraVirus(v);
                return true;
            }
    }
    public ArrayList listaVirus(){
        VirusDAO dao= new VirusDAO();
        ArrayList listados=dao.ListaVirus();
        return listados;    
    }
    
    public Virus busca(int id){
        VirusDAO dao=new VirusDAO();
        Virus virus=dao.busca(id);
        return virus;
    }
    public boolean alterar(Virus virus){
        VirusDAO dao=new VirusDAO();
        if(dao.alterar(virus)==true){
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList buscaComentario(int id){
        VirusDAO dao=new VirusDAO();
        ArrayList comentario=dao.buscaComentario(id);
        return comentario;
    }
    /*public boolean verificaUpdate(Virus virus){
        VirusDAO dao=new VirusDAO();
        if(dao.verificaUpdate(virus)==true){
            return true;
        }else{
            return false;
        }
    }
    */
    
    public boolean remove(int id){
        VirusDAO dao=new VirusDAO();
        if(dao.remove(id)){
            return true;
        }else{
            return false;
        }
     
    }
    /*
    public boolean alterarVirus(Virus v){
        for (Virus viru : virus) {
            if (v.getNome().equals(viru.getNome()) && v.getId() != viru.getId()) {
                return false;
            }
        }
        
        for (Virus viru : virus) {
            if (viru.getId() == v.getId()) {
                viru.setNome(v.getNome());
                viru.setTipo(v.isTipo());
                viru.setDetalhes(v.getDetalhes());
                break;
            }
        }
        
        return true;
    }
    
    public Virus getVirus(int id){
        for (Virus viru : virus) {
            if (viru.getId() == id) {
                return viru;
            }
        }
        return null;
    }
    public Boolean deletaVirus(int id){
        for (Virus viru : virus) {
            if (viru.getId()== id) {
                virus.remove(viru);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Virus> getVirus(){
        return virus;
    }
*/
}

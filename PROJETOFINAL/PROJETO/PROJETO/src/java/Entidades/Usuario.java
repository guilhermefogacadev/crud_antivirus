/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author guilh
 */
@Entity
public class Usuario {
     int id;
     String nome;
     String senha;
     String csenha;
     boolean admin;

   
    List<Comentario> comentario;
    
    public Usuario(String nome, String senha,boolean admin) {
        this.nome = nome;
        this.senha = senha;
        this.admin=admin;
    }
    public Usuario(){
        
    }
    
     public Usuario(String nome, String senha, String csenha) {
        this.nome = nome;
        this.senha = senha;
        this.csenha=csenha;
    }
      public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Column
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @OneToMany(mappedBy = "usuario")
    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getCsenha() {
        return csenha;
    }

    public void setCsenha(String csenha) {
        this.csenha = csenha;
    }
    
    
    
    
    
    
}

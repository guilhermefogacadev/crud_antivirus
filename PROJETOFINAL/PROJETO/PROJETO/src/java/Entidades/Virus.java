/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author guilh
 */
@Entity
public class Virus {
     boolean tipo;
     int id;
     String nome;
     String detalhes;
    
    List<Comentario> comentario;
    
    public Virus(){
        
    }

    public Virus(boolean tipo,String nome, String detalhes) {
        this.tipo = tipo;
        this.nome = nome;
        this.detalhes=detalhes;
   }
    public Virus(int id,boolean tipo,String nome, String detalhes) {
        this.tipo = tipo;
        this.nome = nome;
        this.detalhes=detalhes;
        this.id=id;
   }
    
    @OneToMany(mappedBy = "virus")
    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }
    
  
    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
 
    @Column
    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
    @Column
    public String getNome() {
        return nome;
    }
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}

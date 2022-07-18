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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author guilh
 */
@Entity
public class Comentario {
    String comentario;
    Long id;
    
    
    Usuario usuario;
    Virus virus;

    public Comentario(String comentario) {
        this.comentario = comentario;
    }
    public Comentario(Usuario usuario,Virus virus,String comentario) {
        this.comentario = comentario;
        this.usuario=usuario;
        this.virus=virus;
    }

    public Comentario() {
    }
    
    
    @Column(length = 500)
    public String getComentario() {
        return comentario;
    }

    public void setConteudo(String comentario) {
        this.comentario = comentario;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name ="idusuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // COMO PEGAR O USUARIO QUE COMENTOU , O ID DELE
    
    @ManyToOne
    @JoinColumn(name ="idvirus")
    public Virus getVirus() {
        return virus;
    }

    public void setVirus(Virus virus) {
        this.virus = virus;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

   
    
    
    
}

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tricksterx
 */

@Entity
@Table(name="favoritos")
public class Favorito implements Serializable{
    
    @Id @GeneratedValue
    private Long id_favorito;
    private Long id_usuario;
    private Long id_imovel;
    
    //@OneToOne
    //@JoinTable(name="imoveis", joinColumns = @JoinColumn(name="imovel_id"), inverseJoinColumns=@JoinColumn(name="imovel_id"))

    
    public Long getId_usuario() {
        return id_usuario;
    }

    public Long getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(Long id_imovel) {
        this.id_imovel = id_imovel;
    }

    
    public Long getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(Long id_favorito) {
        this.id_favorito = id_favorito;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }


    
    
}

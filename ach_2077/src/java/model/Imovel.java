package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name="imoveis")
public class Imovel implements Serializable{
    
    @Id @GeneratedValue
    private Long id_imovel;
    
    private String titulo;

    public Long getId_imovel() {
        return id_imovel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId_imovel(Long id_imovel) {
        this.id_imovel = id_imovel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    

   
    
    
    
}

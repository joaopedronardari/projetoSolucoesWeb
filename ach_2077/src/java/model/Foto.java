/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tricksterx
 */

@Entity
@Table(name="fotos_imovel")
public class Foto {
    @Id @GeneratedValue
    private Long id_foto;
    private Long id_imovel;
    private String url;
    private String titulo;
    
    public Long getId_foto() {
        return id_foto;
    }

    public Long getId_imovel() {
        return id_imovel;
    }

    public String getUrl() {
        return url;
    }

    public String getTitulo() {
        return titulo;
    }


    public void setId_foto(Long id_foto) {
        this.id_foto = id_foto;
    }

    public void setId_imovel(Long id_imovel) {
        this.id_imovel = id_imovel;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
}

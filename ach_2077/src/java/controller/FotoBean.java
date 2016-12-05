/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import model.Foto;
import model.Imovel;
import repository.FotoRepository;
import repository.ImovelRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class FotoBean {
    
    private Foto foto;
    
    private EntityManager manager;
    
    @PostConstruct
    public void init() {
        this.foto = new Foto();
        this.manager = this.getEntityManager();
    }
    
    public String adicionaFoto(Long idImovel){
        FotoRepository repository = new FotoRepository(manager);
        foto.setId_imovel(idImovel);
        repository.adiciona(this.foto);
        return "imovel_edit.xhtml?id_imovel=" + idImovel + "&faces-redirect=true"; 
    }
    
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
    }

    public Foto getFoto() {
        return foto;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }


    
    
    
}

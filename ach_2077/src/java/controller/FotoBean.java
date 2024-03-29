/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Foto;
import repository.FotoRepository;

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

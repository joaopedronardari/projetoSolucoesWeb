/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import model.Imovel;
import repository.ImovelRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class ImovelBean {
    
    private Imovel imovel = new Imovel();
    
    public void adicionaImovel(){
        EntityManager manager = this.getEntityManager();
        ImovelRepository repository = new ImovelRepository(manager);
        
        repository.adiciona(this.imovel);
        this.imovel = new Imovel();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
    
    
}

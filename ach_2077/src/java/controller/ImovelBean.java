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
import model.Imovel;
import repository.ImovelRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class ImovelBean {
    
    private Imovel imovel;
    
    private List<Imovel> imoveis;
    
    @PostConstruct
    public void init() {
        imovel = new Imovel();
        
        EntityManager manager = this.getEntityManager();
        ImovelRepository repository = new ImovelRepository(manager);
        
        Map<String, String> urlParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (urlParameters.containsKey("id_imovel")){
            imovel = repository.buscaImovel(urlParameters.get("id_imovel"));
        }
        
        imoveis = repository.buscaTodos();
    }
    
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

    public List<Imovel> getImoveis() {
        return imoveis;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }


    
    
}

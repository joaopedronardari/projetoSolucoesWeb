/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    
    private EntityManager manager;
    
    @PostConstruct
    public void init() {
        this.manager = this.getEntityManager();
        ImovelRepository repository = new ImovelRepository(manager);
        
        imovel = buscaImovel();
        imoveis = repository.buscaTodos();
    }
    
    public String adicionaImovel(){
        ImovelRepository repository = new ImovelRepository(manager);
        this.imovel = repository.adiciona(this.imovel);
        return "imovel_edit.xhtml?id_imovel=" + this.imovel.getId_imovel() + "&faces-redirect=true"; 
    }
    
    public String atualizaImovel(){
        ImovelRepository repository = new ImovelRepository(manager);
        repository.atualiza(this.imovel);
        return "imovel_edit.xhtml?id_imovel=" + this.imovel.getId_imovel() + "&faces-redirect=true"; 
    }
    
    private Imovel buscaImovel(){
        ImovelRepository repository = new ImovelRepository(manager);
        Map<String, String> urlParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        if (urlParameters.containsKey("id_imovel")){
            return repository.buscaImovel(urlParameters.get("id_imovel"));
        }
        
        return new Imovel();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
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

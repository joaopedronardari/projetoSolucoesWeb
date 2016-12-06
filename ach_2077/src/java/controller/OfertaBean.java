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
public class OfertaBean {
    
    private List<Imovel> top3Compra;
    private List<Imovel> top3Aluguel;
    private List<Imovel> top3Casa;
    private List<Imovel> top3Apartamento;
    private List<Imovel> top3Cobertura;
    
    private EntityManager manager;
    
    @PostConstruct
    public void init() {
        this.manager = this.getEntityManager();
        ImovelRepository repository = new ImovelRepository(manager);
        
        top3Compra = repository.top3Compra();
        top3Aluguel = repository.top3Aluguel();
        top3Casa = repository.top3Casa();
        top3Apartamento = repository.top3Apartamento();
        top3Cobertura = repository.top3Cobertura();
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
    }

    public List<Imovel> getTop3Compra() {
        return top3Compra;
    }

    public List<Imovel> getTop3Aluguel() {
        return top3Aluguel;
    }

    public List<Imovel> getTop3Casa() {
        return top3Casa;
    }

    public List<Imovel> getTop3Apartamento() {
        return top3Apartamento;
    }

    public List<Imovel> getTop3Cobertura() {
        return top3Cobertura;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setTop3Compra(List<Imovel> top3Compra) {
        this.top3Compra = top3Compra;
    }

    public void setTop3Aluguel(List<Imovel> top3Aluguel) {
        this.top3Aluguel = top3Aluguel;
    }

    public void setTop3Casa(List<Imovel> top3Casa) {
        this.top3Casa = top3Casa;
    }

    public void setTop3Apartamento(List<Imovel> top3Apartamento) {
        this.top3Apartamento = top3Apartamento;
    }

    public void setTop3Cobertura(List<Imovel> top3Cobertura) {
        this.top3Cobertura = top3Cobertura;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }



    
    
    
    
}

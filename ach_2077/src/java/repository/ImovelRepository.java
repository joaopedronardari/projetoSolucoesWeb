/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Imovel;

/**
 *
 * @author tricksterx
 */
public class ImovelRepository {
    private EntityManager manager;
    
    
    public ImovelRepository (EntityManager manager){
        this.manager = manager;
    }
    
    public Imovel adiciona (Imovel imovel){
        Date now = new Date();
        imovel.setData_anuncio(now);
        this.manager.getTransaction().begin();
        this.manager.persist(imovel);
        this.manager.getTransaction().commit();
        
        return imovel;
    }
    
    public Imovel atualiza (Imovel imovel){
        this.manager.getTransaction().begin();
        this.manager.merge(imovel);
        this.manager.getTransaction().commit();

        return imovel;
    }
    
    public List<Imovel> buscaTodos(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x");
        return query.getResultList();
    }
    
    public Imovel buscaImovel(String idImovel){
        return this.manager.find(Imovel.class, Long.parseLong(idImovel));
    }
}

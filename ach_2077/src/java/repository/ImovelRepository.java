/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

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
    
    public void adiciona (Imovel imovel){
        this.manager.getTransaction().begin();
        this.manager.persist(imovel);
        this.manager.getTransaction().commit();
    }
    
    public List<Imovel> buscaTodos(){
        Query query = this.manager.createQuery("SELECT * FROM imoveis");
        return query.getResultList();
    }
}

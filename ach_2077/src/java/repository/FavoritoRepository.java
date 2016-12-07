/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Favorito;
import model.Imovel;

/**
 *
 * @author tricksterx
 */
public class FavoritoRepository {
    private EntityManager manager;
    
    
    public FavoritoRepository (EntityManager manager){
        this.manager = manager;
    }
    
    public void adiciona (Favorito favorito){
        this.manager.getTransaction().begin();
        this.manager.persist(favorito);
        this.manager.getTransaction().commit();
    }
   
    public List<Imovel> favoritos (Long idUsuario){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x JOIN x.favoritos y WHERE y.id_usuario = :id_usuario");
        query.setParameter("id_usuario", idUsuario);
        
        return query.getResultList();
    }
}

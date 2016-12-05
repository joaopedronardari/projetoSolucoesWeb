/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import javax.persistence.EntityManager;
import model.Foto;

/**
 *
 * @author tricksterx
 */
public class FotoRepository {
    private EntityManager manager;
    
    
    public FotoRepository (EntityManager manager){
        this.manager = manager;
    }
    
    public Foto adiciona (Foto foto){
        this.manager.getTransaction().begin();
        this.manager.persist(foto);
        this.manager.getTransaction().commit();
        return foto;
    }
}

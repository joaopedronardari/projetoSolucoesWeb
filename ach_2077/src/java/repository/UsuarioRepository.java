/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import javax.persistence.EntityManager;
import model.Usuario;

/**
 *
 * @author tricksterx
 */
public class UsuarioRepository {
    private EntityManager manager;
    
    
    public UsuarioRepository (EntityManager manager){
        this.manager = manager;
    }
    
    public Usuario adiciona (Usuario usuario){
        this.manager.getTransaction().begin();
        this.manager.persist(usuario);
        this.manager.getTransaction().commit();
        
        return usuario;
    }
   
}

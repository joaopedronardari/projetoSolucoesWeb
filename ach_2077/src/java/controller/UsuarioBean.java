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
import model.Usuario;
import repository.UsuarioRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class UsuarioBean {
    
    private Usuario usuario;
    
    private EntityManager manager;
    
    @PostConstruct
    public void init() {
        this.manager = this.getEntityManager();
        usuario = new Usuario();
    }
    
    public String adicionaUsuario(){
        UsuarioRepository repository = new UsuarioRepository(manager);
        this.usuario = repository.adiciona(this.usuario);
        return "index.xhtml?id_usuario=" + this.usuario.getId_usuario() + "&faces-redirect=true"; 
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
    }

    public Usuario getUsuario() {
        return usuario;
    }


    
    
}

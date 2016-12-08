/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Favorito;
import model.Imovel;
import model.Mensagem;
import repository.FavoritoRepository;
import repository.MensagemRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class FavoritoBean {
    
    private Favorito favorito;
    private EntityManager manager;
    
    private List<Imovel> favoritos;
    
    @PostConstruct
    public void init() {
        this.manager = this.getEntityManager();
        favoritos = new ArrayList<>();
        favorito = new Favorito();
        
        FavoritoRepository repository = new FavoritoRepository(manager);
        if (SessionUtils.getParam("username") != null){
            System.out.println("FAVORITOS DO USER -> " + SessionUtils.getParam("userid"));
            favoritos = repository.favoritos((Long) SessionUtils.getParam("userid"));
        }
    }
    
    
    public String adicionaFavorito(){
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long idUsuario = (Long) SessionUtils.getParam("userid");
        String idImovel = parameterMap.get("id_imovel");
        
        FavoritoRepository repository = new FavoritoRepository(manager);
        favorito.setId_usuario(idUsuario);
        favorito.setId_imovel(Long.parseLong(idImovel));
        repository.adiciona(favorito);
        
        return "imovel_view.xhtml?id_imovel=" + idImovel + "&faces-redirect=true&alert=favorito"; 
    }
   
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
    }

    public List<Imovel> getFavoritos() {
        return favoritos;
    }



    
    
    
    
    
}

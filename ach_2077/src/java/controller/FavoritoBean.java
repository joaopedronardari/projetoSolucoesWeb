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
        
        //TODO: colocar id do usuario logado, if logado
        FavoritoRepository repository = new FavoritoRepository(manager);
        if (true){
            favoritos = repository.favoritos(1L);
        }
    }
    
    
    public String adicionaFavorito(){
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idUsuario = parameterMap.get("id_usuario");
        String idImovel = parameterMap.get("id_imovel");
        
        FavoritoRepository repository = new FavoritoRepository(manager);
        favorito.setId_usuario(Long.parseLong(idUsuario));
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

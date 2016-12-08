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
import model.Mensagem;
import repository.MensagemRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class MensagemBean {
    
    private Mensagem mensagem;
    
    private EntityManager manager;
    
    private List<Mensagem> mensagensRecebidas;
    private List<Mensagem> mensagensEnviadas;
    
    @PostConstruct
    public void init() {
        this.manager = this.getEntityManager();
        mensagem = new Mensagem();
        mensagensRecebidas = new ArrayList<>();
        mensagensEnviadas = new ArrayList<>();
        
        MensagemRepository repository = new MensagemRepository(manager);
        if (SessionUtils.getParam("username") != null){
            mensagensRecebidas = repository.mensagensRecebidas((Long) SessionUtils.getParam("userid"));
            mensagensEnviadas = repository.mensagensEnviadas((Long) SessionUtils.getParam("userid"));
        }
    }
    
    public String enviaMensagem(){
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idDestinatario = parameterMap.get("id_usuario");
        String idImovel = parameterMap.get("id_imovel");
        
        MensagemRepository repository = new MensagemRepository(manager);
        mensagem.setId_usuario_destinatario(Long.parseLong(idDestinatario));
        mensagem.setData_envio(new Date());
        mensagem.setId_usuario_remetente((Long) SessionUtils.getParam("userid"));
        repository.adiciona(mensagem);
        
        return "imovel_view.xhtml?id_imovel=" + idImovel + "&faces-redirect=true&alert=mensagem"; 
    }
    
    public String responderMensagem(String resposta){
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idDestinatario = parameterMap.get("id_usuario");
        
        MensagemRepository repository = new MensagemRepository(manager);
        mensagem.setId_usuario_destinatario(Long.parseLong(idDestinatario));
        mensagem.setData_envio(new Date());
        mensagem.setMensagem(resposta);
        mensagem.setId_usuario_remetente((Long) SessionUtils.getParam("userid"));
        repository.adiciona(mensagem);
        
        return "mensagem_list.xhtml?faces-redirect=true&alert=true"; 
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public List<Mensagem> getMensagensRecebidas() {
        return mensagensRecebidas;
    }

    public List<Mensagem> getMensagensEnviadas() {
        return mensagensEnviadas;
    }


    
    
    
    
    
}

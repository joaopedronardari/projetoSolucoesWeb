/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import controller.BuscaBean;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Imovel;
import model.Mensagem;

/**
 *
 * @author tricksterx
 */
public class MensagemRepository {
    private EntityManager manager;
    
    
    public MensagemRepository (EntityManager manager){
        this.manager = manager;
    }
    
    public Mensagem adiciona (Mensagem mensagem){
        this.manager.getTransaction().begin();
        this.manager.persist(mensagem);
        this.manager.getTransaction().commit();
        
        return mensagem;
    }
   
    public List<Mensagem> mensagensRecebidas(Long idUsuario){
        Query query = this.manager.createQuery("SELECT x FROM Mensagem x WHERE x.id_usuario_destinatario = :id_usuario ORDER BY data_envio DESC");
        query.setParameter("id_usuario", idUsuario);
        
        return query.getResultList();
    }
    
    public List<Mensagem> mensagensEnviadas(Long idUsuario){
        Query query = this.manager.createQuery("SELECT x FROM Mensagem x WHERE x.id_usuario_remetente = :id_usuario ORDER BY data_envio DESC");
        query.setParameter("id_usuario", idUsuario);
        
        return query.getResultList();
    }
}

package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tricksterx
 */

@Entity
@Table(name="mensagem")
public class Mensagem implements Serializable{
    
    @Id @GeneratedValue
    private Long id_mensagem;
    private Long id_usuario_remetente;
    private Long id_usuario_destinatario;
    private String mensagem;
    private Date data_envio;

    

    public Long getId_mensagem() {
        return id_mensagem;
    }

    public Long getId_usuario_remetente() {
        return id_usuario_remetente;
    }

    public Long getId_usuario_destinatario() {
        return id_usuario_destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Date getData_envio() {
        return data_envio;
    }


    public void setId_mensagem(Long id_mensagem) {
        this.id_mensagem = id_mensagem;
    }

    public void setId_usuario_remetente(Long id_usuario_remetente) {
        this.id_usuario_remetente = id_usuario_remetente;
    }

    public void setId_usuario_destinatario(Long id_usuario_destinatario) {
        this.id_usuario_destinatario = id_usuario_destinatario;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setData_envio(Date data_envio) {
        this.data_envio = data_envio;
    }
    
    
    
}

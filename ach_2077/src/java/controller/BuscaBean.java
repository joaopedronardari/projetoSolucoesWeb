/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Imovel;
import repository.ImovelRepository;

/**
 *
 * @author tricksterx
 */

@ManagedBean
public class BuscaBean {
    
    private List<Imovel> imoveis;
    
    private String titulo;
    private String tipo;
    private String estado;
    private String cidade;
    private String endereco;
    private String preco_venda_min;
    private String preco_venda_max;
    private String preco_aluguel_min;
    private String preco_aluguel_max;
    private String preco_condominio_min;
    private String preco_condominio_max;
    private String area_min;
    private String area_max;
    
    private EntityManager manager;
    
    @PostConstruct
    public void init() {
        
        this.manager = this.getEntityManager();
        ImovelRepository repository = new ImovelRepository(manager);
        
        imoveis = repository.buscaTodos();
    }
    
    public void filtraImoveis(){
        ImovelRepository repository = new ImovelRepository(manager);
        imoveis = repository.buscaAvancada(this);
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ach_2077PU");
        return factory.createEntityManager();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPreco_venda_min() {
        return preco_venda_min;
    }

    public String getPreco_venda_max() {
        return preco_venda_max;
    }

    public String getPreco_aluguel_min() {
        return preco_aluguel_min;
    }

    public String getPreco_aluguel_max() {
        return preco_aluguel_max;
    }

    public String getPreco_condominio_min() {
        return preco_condominio_min;
    }

    public String getPreco_condominio_max() {
        return preco_condominio_max;
    }

    public String getArea_min() {
        return area_min;
    }

    public String getArea_max() {
        return area_max;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPreco_venda_min(String preco_venda_min) {
        this.preco_venda_min = preco_venda_min;
    }

    public void setPreco_venda_max(String preco_venda_max) {
        this.preco_venda_max = preco_venda_max;
    }

    public void setPreco_aluguel_min(String preco_aluguel_min) {
        this.preco_aluguel_min = preco_aluguel_min;
    }

    public void setPreco_aluguel_max(String preco_aluguel_max) {
        this.preco_aluguel_max = preco_aluguel_max;
    }

    public void setPreco_condominio_min(String preco_condominio_min) {
        this.preco_condominio_min = preco_condominio_min;
    }

    public void setPreco_condominio_max(String preco_condominio_max) {
        this.preco_condominio_max = preco_condominio_max;
    }

    public void setArea_min(String area_min) {
        this.area_min = area_min;
    }

    public void setArea_max(String area_max) {
        this.area_max = area_max;
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }


    
    
}

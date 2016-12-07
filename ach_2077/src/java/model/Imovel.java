package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="imoveis")
public class Imovel implements Serializable{
    
    @Id @GeneratedValue
    private Long id_imovel;
    private Long id_usuario;
    private String titulo;
    private String descricao;
    private Double preco_venda;
    private Double preco_aluguel;
    private Double preco_condominio;
    private String endereco;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private String tipo;
    private Date data_anuncio;
    private Integer area;
    private Integer quartos;
    private Integer vagas;
    private Integer suites;
    private Integer visitas;
    
    @ElementCollection(targetClass=Foto.class)
    @JoinTable(
        name = "fotos_imovel", 
        joinColumns = @JoinColumn(name = "id_imovel"), 
        inverseJoinColumns = @JoinColumn(name = "id_foto")
    )
    private Collection<Foto> fotos;

    public Collection<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(Collection<Foto> fotos) {
        this.fotos = fotos;
    }

    
    public Long getId_imovel() {
        return id_imovel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public Double getPreco_aluguel() {
        return preco_aluguel;
    }

    public Double getPreco_condominio() {
        return preco_condominio;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getData_anuncio() {
        return data_anuncio;
    }

    public Integer getArea() {
        return area;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public Integer getVagas() {
        return vagas;
    }

    public Integer getSuites() {
        return suites;
    }

    public void setId_imovel(Long id_imovel) {
        this.id_imovel = id_imovel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public void setPreco_aluguel(Double preco_aluguel) {
        this.preco_aluguel = preco_aluguel;
    }

    public void setPreco_condominio(Double preco_condominio) {
        this.preco_condominio = preco_condominio;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData_anuncio(Date data_anuncio) {
        this.data_anuncio = data_anuncio;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void setSuites(Integer suites) {
        this.suites = suites;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

   
    
    
    
}

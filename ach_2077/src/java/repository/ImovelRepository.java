/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import controller.BuscaBean;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Imovel;

/**
 *
 * @author tricksterx
 */
public class ImovelRepository {
    private EntityManager manager;
    
    
    public ImovelRepository (EntityManager manager){
        this.manager = manager;
    }
    
    public Imovel adiciona (Imovel imovel){
        Date now = new Date();
        imovel.setData_anuncio(now);
        this.manager.getTransaction().begin();
        this.manager.persist(imovel);
        this.manager.getTransaction().commit();
        
        return imovel;
    }
    
    public Imovel atualiza (Imovel imovel){
        this.manager.getTransaction().begin();
        this.manager.merge(imovel);
        this.manager.getTransaction().commit();

        return imovel;
    }
    
    public List<Imovel> buscaTodos(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x");
        return query.getResultList();
    }
    
    public List<Imovel> buscaAvancada(BuscaBean busca){
        String condition = " WHERE 1=1 ";
        
        condition += (!isEmpty(busca.getTitulo())) ? " AND x.titulo LIKE :titulo " : "";
        condition += (!isEmpty(busca.getTipo())) ? " AND x.tipo = :tipo " : "";
        condition += (!isEmpty(busca.getEstado())) ? " AND x.estado LIKE :estado " : "";
        condition += (!isEmpty(busca.getCidade())) ? " AND x.cidade LIKE :cidade " : "";
        condition += (!isEmpty(busca.getEndereco())) ? " AND x.endereco LIKE :endereco " : "";
        condition += (!isEmpty(busca.getPreco_venda_min())) ? " AND x.preco_venda >= :min_preco_venda " : "";
        condition += (!isEmpty(busca.getPreco_venda_max())) ? " AND x.preco_venda <= :max_preco_venda " : "";
        condition += (!isEmpty(busca.getPreco_aluguel_min())) ? " AND x.preco_aluguel >= :min_preco_aluguel" : "";
        condition += (!isEmpty(busca.getPreco_aluguel_max())) ? " AND x.preco_aluguel <= :max_preco_aluguel " : "";
        condition += (!isEmpty(busca.getPreco_condominio_min())) ? " AND x.preco_condominio >= :min_preco_condominio " : "";
        condition += (!isEmpty(busca.getPreco_condominio_max())) ? " AND x.preco_condominio <= :max_preco_condominio " : "";
        condition += (!isEmpty(busca.getArea_min())) ? " AND x.area >= :min_area " : "";
        condition += (!isEmpty(busca.getArea_max())) ? " AND x.area <= :max_area " : "";
        
        Query query = this.manager.createQuery("SELECT x FROM Imovel x " + condition);
        
        if (!isEmpty(busca.getTitulo())) query.setParameter("titulo", "%"+busca.getTitulo()+"%");
        if (!isEmpty(busca.getTipo())) query.setParameter("tipo", busca.getTipo());
        if (!isEmpty(busca.getEstado())) query.setParameter("estado", "%"+busca.getEstado()+"%");
        if (!isEmpty(busca.getCidade())) query.setParameter("cidade", "%"+busca.getCidade()+"%");
        if (!isEmpty(busca.getEndereco())) query.setParameter("endereco", "%"+busca.getEndereco()+"%");
        if (!isEmpty(busca.getPreco_venda_min())) query.setParameter("min_preco_venda", Double.parseDouble(busca.getPreco_venda_min()));
        if (!isEmpty(busca.getPreco_venda_max())) query.setParameter("max_preco_venda", Double.parseDouble(busca.getPreco_venda_max()));
        if (!isEmpty(busca.getPreco_aluguel_min())) query.setParameter("min_preco_aluguel", Double.parseDouble(busca.getPreco_aluguel_min()));
        if (!isEmpty(busca.getPreco_aluguel_max())) query.setParameter("max_preco_aluguel", Double.parseDouble(busca.getPreco_aluguel_max()));
        if (!isEmpty(busca.getPreco_condominio_min())) query.setParameter("min_preco_condominio", Double.parseDouble(busca.getPreco_condominio_min()));
        if (!isEmpty(busca.getPreco_condominio_max())) query.setParameter("max_preco_condominio", Double.parseDouble(busca.getPreco_condominio_max()));
        if (!isEmpty(busca.getArea_min())) query.setParameter("min_area", Double.parseDouble(busca.getArea_min()));
        if (!isEmpty(busca.getArea_max())) query.setParameter("max_area", Double.parseDouble(busca.getArea_max()));
        
        return query.getResultList();
    }
    
    public Imovel buscaImovel(String idImovel){
        return this.manager.find(Imovel.class, Long.parseLong(idImovel));
    }
    
    public void incrementaVisita(Imovel imovel){
        imovel.setVisitas(imovel.getVisitas()+1);
        atualiza(imovel);
    }
    
    
    public List<Imovel> top3Compra(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x ORDER BY (x.preco_venda/x.area) ASC");
        return query.setMaxResults(3).getResultList();
    }
    
    public List<Imovel> top3Aluguel(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x ORDER BY (x.preco_aluguel/x.area) ASC");
        return query.setMaxResults(3).getResultList();
    }
    
    public List<Imovel> top3Casa(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x ORDER BY visitas DESC");
        return query.setMaxResults(3).getResultList();
    }
    
    public List<Imovel> top3Apartamento(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x ORDER BY visitas DESC");
        return query.setMaxResults(3).getResultList();
    }
    
    public List<Imovel> top3Cobertura(){
        Query query = this.manager.createQuery("SELECT x FROM Imovel x ORDER BY visitas DESC");
        return query.setMaxResults(3).getResultList();
    }
    
    
    private boolean isEmpty(String text){
        return text == null || text.isEmpty();
    }
}

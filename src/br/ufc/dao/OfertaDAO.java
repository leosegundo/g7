package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Oferta;

@Repository
public class OfertaDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Oferta oferta) {
		manager.persist(oferta);
	}
	public void alterar(Oferta oferta) {
		manager.merge(oferta);
	}
	
	
	public List<Oferta> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select o from oferta as o",
				Oferta.class).getResultList();
	}
	
public List<Oferta> recuperarOferta(Classificado id) {
		
		String hql = "select o from oferta as o "
					+"where o.classificado = :param_classificado";
		
		Query query = manager.createQuery(hql);
		List<Oferta> ofertas = 
				query.setParameter("param_classificados", id).getResultList();
		
		if(ofertas.size()!=0){
			return ofertas;
		}
		
		return null;
	}
}

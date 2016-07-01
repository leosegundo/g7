package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Repository
public class NoticiaDAOHib{
	@PersistenceContext
	private EntityManager manager;

	
	public void inserir(Noticia noticia) {
		// TODO Auto-generated method stub
		manager.persist(noticia);
	}

	public Noticia recuperar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Noticia.class, id);
	}
	
	
	public void alterar(Noticia noticia) {
		// TODO Auto-generated method stub
		manager.merge(noticia);
	}
	
	
	public List<Noticia> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select n from noticia as n",
				Noticia.class).getResultList();
	}
	
	
	public void apagar(Long id) {
		// TODO Auto-generated method stub
		Noticia aux = this.recuperar(id);
		
		if(aux != null){
			manager.remove(aux);
		}
		
	}
	
}

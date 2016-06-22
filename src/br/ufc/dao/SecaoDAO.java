package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Repository
public class SecaoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void inserir(Secao secao) {
		manager.persist(secao);	
	}
	
	public Secao recuperar(String secao) {
		Long s = (long) Integer.parseInt(secao);
		
		return manager.find(Secao.class, s);

	}
	
	public Secao recuperar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Secao.class, id);
	}
	
	public List<Secao> listar() {
		return manager.createQuery("select s from secao as s",
				Secao.class).getResultList();
	}
}

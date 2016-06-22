package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Classificado;
import br.ufc.model.Noticia;

@Repository
public class ClassificadoDAO {

	
	@PersistenceContext
	private EntityManager manager;
	
	public void inserir(Classificado classificado) {
		// TODO Auto-generated method stub
		manager.persist(classificado);
	}
	
	public void alterar(Classificado classificado) {
		// TODO Auto-generated method stub
		manager.merge(classificado);
	}

	public Classificado recuperar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Classificado.class, id);
	}
	
	public List<Classificado> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select c from classificado as c",
				Classificado.class).getResultList();
	}
}

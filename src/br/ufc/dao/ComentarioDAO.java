package br.ufc.dao;

import java.util.List; 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Aluno;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;

@Repository
public class ComentarioDAO{
	@PersistenceContext
	private EntityManager manager;

	public void inserir(Comentario comentario) {
		// TODO Auto-generated method stub
		System.out.println("inserido o/");
		manager.persist(comentario);
		System.out.println("passou"+ comentario.getTexto());
		
	}


	public List<Comentario> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("select c from comentario as c",
				Comentario.class).getResultList();
	}
	
	
	public List<Comentario> recuperarComentario(Noticia id) {
		
		String hql = "select c from comentario as c "
					+"where c.noticia = :param_noticia";
		
		Query query = manager.createQuery(hql);
		List<Comentario> comentarios = 
				query.setParameter("param_noticia", id).getResultList();
		
		if(comentarios.size()!=0){
			return comentarios;
		}
		
		return null;
	}
	
	
}

package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import org.springframework.stereotype.Repository;

import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Repository
public class UsuarioDAOHib{
	@PersistenceContext
	private EntityManager manager;

	
	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.persist(usuario);
	}

	
	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		manager.merge(usuario);
	}

	
	public Usuario recuperar(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Usuario.class, id);
	}

	
	public Usuario recuperar(String login) {
		// TODO Auto-generated method stub
		String hql = "select u from usuario as u "
				+"where u.login = :param_login";
	
		Query query = manager.createQuery(hql);
		List<Usuario> usuarios = 
				query.setParameter("param_login", login).getResultList();
		
		if(usuarios.size()!=0){
			return usuarios.get(0);
		}

		return null;
	}
	
	
	public void apagar(Long id) {
		// TODO Auto-generated method stub
		Usuario aux = this.recuperar(id);
		
		if(aux != null){
			manager.remove(aux);
		}
		
	}

	
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return manager.createQuery("Select u from usuario as u",
				Usuario.class).getResultList();
	}

	
	public Usuario recuperar(String usuario, boolean x) {
		// TODO Auto-generated method stub
		Long u = (long) Integer.parseInt(usuario);
		
		return manager.find(Usuario.class, u);

	}	
	/*
	public Papel recuperarPapel(Long id) {
		// TODO Auto-generated method stub
		String hql = "select p from papel_usuario as p "
				+"where p.USUARIO_ID = :param_id";
	
		Query query = manager.createQuery(hql);
		List<Papel> papeis = 
				query.setParameter("param_id", id).getResultList();
		
		if(papeis.size()!=0){
			return papeis.get(0);
		}

		return null;
	}*/
}

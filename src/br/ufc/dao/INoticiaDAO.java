package br.ufc.dao;

import java.util.List;

import br.ufc.model.Aluno;
import br.ufc.model.Noticia;

public interface INoticiaDAO {
	public void inserir(Noticia noticia);
	public List<Noticia> listar();
	
	/*secao */
	public Noticia recuperar(Long id);
	
}

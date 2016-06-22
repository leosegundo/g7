package br.ufc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//import br.ufc.sistema.Order;

@Entity(name="papel")
public class Papel {
	@Id
	@Column(name="papel_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String papel;

	
	//@ManyToMany(mappedBy="listaPapeis", fetch=FetchType.LAZY)
	//private List<Usuario> listaUsuarios;
	
	@ManyToMany(mappedBy="listaPapeis", fetch=FetchType.LAZY)
	private List<Usuario> usuarioLis;
	
	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Usuario> getUsuarioLis() {
		return usuarioLis;
	}

	public void setUsuarioLis(List<Usuario> usuarioLis) {
		this.usuarioLis = usuarioLis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}

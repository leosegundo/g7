package br.ufc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="secao")
public class Secao {

	@Id
	@Column(name="SECAO_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long secaoId;
	
	private String titulo;
	
	private String descricao;
	
	private String cor;
	
	
	@OneToMany(mappedBy="secao",
			 targetEntity=Noticia.class,
			 fetch=FetchType.EAGER)
	private List<Noticia> noticia;
	
	public List<Noticia> getNoticia() {
		return noticia;
	}

	public void setNoticia(List<Noticia> noticia) {
		this.noticia = noticia;
	}

	public Long getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(Long secaoId) {
		this.secaoId = secaoId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}

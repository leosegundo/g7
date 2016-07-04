package br.ufc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="noticia")
public class Noticia {
	@Id
	@Column(name="NOTICIA_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long noticiaId;
	
	private String titulo;
	
	private String texto;
	
	
	/*relacionamento pro comentario*/
	@OneToMany(mappedBy="noticia",
			 targetEntity=Comentario.class,
			 fetch=FetchType.EAGER)
	private List<Comentario> comentario;
	
	/*relacionamento com seção*/
	@ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_secao", referencedColumnName="SECAO_ID" ,unique=false)
	private Secao secao;
	
		
	@ManyToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="id_autor",
				referencedColumnName="id", unique=false)
	private Usuario autor;
	
	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}

	public Long getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(Long noticiaId) {
		this.noticiaId = noticiaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	
	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}	
}

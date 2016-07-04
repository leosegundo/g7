package br.ufc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="oferta")
public class Oferta {
	
	@Id
	@Column(name="id_oferta",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_oferta;
	
	@ManyToOne(optional=false, cascade=CascadeType.REMOVE)
    @JoinColumn(name = "id", referencedColumnName="id" ,unique=false)
	private Usuario idUsuario;
	
	@OneToOne(cascade = CascadeType.ALL, optional=true)
	@JoinColumn(name="CLASSIFICADO_ID",referencedColumnName="CLASSIFICADO_ID")
	private Classificado idClassificado;
	
	
	private Double oferta;


	public Long getId_oferta() {
		return id_oferta;
	}


	public void setId_oferta(Long id_oferta) {
		this.id_oferta = id_oferta;
	}


	public Usuario getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Classificado getIdClassificado() {
		return idClassificado;
	}


	public void setIdClassificado(Classificado idClassificado) {
		this.idClassificado = idClassificado;
	}


	public Double getOferta() {
		return oferta;
	}


	public void setOferta(Double oferta) {
		this.oferta = oferta;
	}
	

}

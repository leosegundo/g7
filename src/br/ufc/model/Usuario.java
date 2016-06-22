package br.ufc.model;


import java.util.Collection;
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
import javax.persistence.OneToMany;

//import br.ufc.sistema.Product;


@Entity(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	private String email;
	
	/*@ManyToMany
	//id desse usuario
	@JoinTable(name="PAPEL_USUARIO",
			joinColumns=@JoinColumn(name="USUARIO_ID",
									referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="PAPEL_ID",
										   referencedColumnName="id"))
	private List<Papel> listaPapeis;*/
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PAPEL_USUARIO",
		joinColumns=@JoinColumn(name="id",
								referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="papel_id",
									   referencedColumnName="papel_id")
		
	)
	private List<Papel> listaPapeis;
	
	
	@OneToMany(mappedBy="autor",
			   targetEntity=Noticia.class,
			   fetch=FetchType.EAGER)
	private Collection<Noticia> noticias;
	
	public List<Papel> getListaPapeis() {
		return listaPapeis;
	}

	public void setListaPapeis(List<Papel> listaPapeis) {
		this.listaPapeis = listaPapeis;
	}

	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		MD5Criptografia md5 = new MD5Criptografia();
	        this.senha = md5.criptografar(senha);
		//this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Usuario))
			return false;
		
		Usuario ref = (Usuario)obj;
		if(ref.getId()==this.id)
			return true;
		return false;
		
	}
	

	
}

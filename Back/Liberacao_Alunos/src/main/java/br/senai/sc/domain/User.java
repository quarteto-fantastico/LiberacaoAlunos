package br.senai.sc.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CollectionTable;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.senai.sc.domain.enums.Perfil;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Column(unique=true, nullable=false)
	private String email;
	@JsonIgnore
	private String senha;
	@JsonIgnore
	private Date create_time = Calendar.getInstance().getTime();
	
	//@JsonIgnore
	private boolean ativo;
	
//	@JsonIgnore
//	@ElementCollection
//	@CollectionTable(name="TELEFONE_USER")
//	private Set<String> telefones = new HashSet<>();
	private String telefone;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	
	public User() {
		addPerfil(Perfil.GUARDA);
	}

	public User(Integer id, String nome, String email, String senha, String telefone, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.ativo = ativo;
		addPerfil(Perfil.GUARDA);
	}

//	public Set<String> getTelefones() {
//		return telefones;
//	}
//
//
//	public void setTelefones(Set<String> telefones) {
//		this.telefones = telefones;
//	}
	
	
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(p -> Perfil.toEnum(p)).collect(Collectors.toSet());
	}
	
	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCodigo());
	}
	
	public Integer getId() {
		return id;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Date getCreate_time() {
		return create_time;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	

}

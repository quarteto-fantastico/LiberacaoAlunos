package br.senai.sc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	@JsonIgnore
	@Lob
	private byte[] foto;
	
	@JsonIgnore
	private Date create_time;
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<RegistroSaida> registros_saidas = new ArrayList<RegistroSaida>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<RegistroEntrada> registros_entradas = new ArrayList<RegistroEntrada>();
	

//	@ManyToMany
//	@JoinTable(name = "TURMA_ALUNO",
//			joinColumns = @JoinColumn(name="turma_id"),
//			inverseJoinColumns = @JoinColumn(name="aluno_id"))
//	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ALUNO_TURMA",
	joinColumns = @JoinColumn(name="aluno_id"),
	inverseJoinColumns = @JoinColumn(name="turma_id"))
	private List<Turma> turmas = new ArrayList<Turma>();
	
	@JsonIgnore
	@ElementCollection
	@CollectionTable(name="TELEFONE_ALUNO")
	private Set<String> telefones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Responsavel> responsaveis = new ArrayList<Responsavel>();
	
	public Aluno() {
		
	}

	
	
	
	public Aluno(Integer id, String nome, String cpf, byte[] foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.foto = foto;
		this.create_time = Calendar.getInstance().getTime();
	}




	public List<Turma> getTurmas() {
		return turmas;
	}




	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}




	public Integer getId() {
		return id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Date getCreate_time() {
		return create_time;
	}

	
	public List<RegistroSaida> getRegistros_saidas() {
		return registros_saidas;
	}




	public void setRegistros_saidas(List<RegistroSaida> registros_saidas) {
		this.registros_saidas = registros_saidas;
	}

	
	public List<RegistroEntrada> getRegistros_entradas() {
		return registros_entradas;
	}




	public void setRegistros_entradas(List<RegistroEntrada> registros_entradas) {
		this.registros_entradas = registros_entradas;
	}

	



	public Set<String> getTelefones() {
		return telefones;
	}




	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	




	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}




	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

package br.senai.sc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
	}
	
	public Professor(Integer id, String nome, String email, String senha, String telefone, boolean ativo) {
		super(id, nome, email, senha, telefone, ativo);
	}


	@JsonIgnore
	@ManyToMany(mappedBy = "professores")
	private List<RegistroSaida>registros_saidas = new ArrayList<RegistroSaida>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "professores")
	private List<RegistroEntrada> registros_entradas = new ArrayList<RegistroEntrada>();

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
	

	
	
}

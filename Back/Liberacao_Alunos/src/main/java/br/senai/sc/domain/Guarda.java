package br.senai.sc.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Guarda extends User implements Serializable{
	private static final long serialVersionUID = 1L;

	public Guarda() {
		super();
	}
	
	

	public Guarda(Integer id, String nome, String email, String senha, String telefone, boolean ativo) {
		super(id, nome, email, senha, telefone, ativo);
	}
	
}
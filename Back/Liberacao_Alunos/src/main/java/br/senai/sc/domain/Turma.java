package br.senai.sc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.senai.sc.domain.enums.Periodo;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome_curso;
	private Integer periodo;
	private String fase; 
	private String ano_semestre;
	
//	@JsonIgnoreProperties({"nome", "cpf", "create_time"})
//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(name = "TURMA_ALUNO",
//			joinColumns = @JoinColumn(name="turma_id"),
//			inverseJoinColumns = @JoinColumn(name="aluno_id"))
	@JsonIgnore
	@ManyToMany(mappedBy="turmas")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	
	public Turma() {
		
	}
	
	public Turma(Integer id, String nome_curso, String fase, String ano_semestre, Periodo periodo) {
		super();
		this.id = id;
		this.nome_curso = nome_curso;
		this.fase = fase;
		this.ano_semestre = ano_semestre;
		this.periodo = periodo.getCodigo();
	}
	
	

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_curso() {
		return nome_curso;
	}

	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getAno_semestre() {
		return ano_semestre;
	}

	public void setAno_semestre(String ano_semestre) {
		this.ano_semestre = ano_semestre;
	}
	
	public Periodo getPeriodo() {
		return Periodo.toEnum(periodo);
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo.getCodigo();
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}

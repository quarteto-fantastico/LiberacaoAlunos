package br.senai.sc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RegistroSaida implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String observacao;
	private Date hora_saida;
	private Date repetir_ate;
	private Boolean segunda;
	private Boolean terca;
	private Boolean quarta;
	private Boolean quinta;
	private Boolean sexta;
	private Boolean sabado;
	private Boolean notificar_resp;
	//private String msg_resp;
	private Boolean notificar_prof;
	//private String msg_prof;
	
	private Date create_time = Calendar.getInstance().getTime();
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "administrador_id")
	private Administrador administrador;

//	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PROFESSOR_NOTIFICADO_SAIDA",
				joinColumns = @JoinColumn(name = "registro_saida_id"),
				inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private List<Professor>professores = new ArrayList<Professor>();
	
	public RegistroSaida() {
	}

	public RegistroSaida(Integer id, String observacao, Date hora_saida, Date repetir_ate, Boolean segunda,
			Boolean terca, Boolean quarta, Boolean quinta, Boolean sexta, Boolean sabado, Boolean notificar_resp, Boolean notificar_prof, Administrador administrador,Aluno aluno) {
		super();
		this.id = id;
		this.observacao = observacao;
		this.hora_saida = hora_saida;
		this.repetir_ate = repetir_ate;
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.notificar_resp = notificar_resp;
		this.notificar_prof = notificar_prof;
		this.administrador = administrador;
		this.aluno = aluno;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getHora_saida() {
		return hora_saida;
	}

	public void setHora_saida(Date hora_saida) {
		this.hora_saida = hora_saida;
	}

	public Date getRepetir_ate() {
		return repetir_ate;
	}

	public void setRepetir_ate(Date repetir_ate) {
		this.repetir_ate = repetir_ate;
	}

	public Boolean getSegunda() {
		return segunda;
	}

	public void setSegunda(Boolean segunda) {
		this.segunda = segunda;
	}

	public Boolean getTerca() {
		return terca;
	}

	public void setTerca(Boolean terca) {
		this.terca = terca;
	}

	public Boolean getQuarta() {
		return quarta;
	}

	public void setQuarta(Boolean quarta) {
		this.quarta = quarta;
	}

	public Boolean getQuinta() {
		return quinta;
	}

	public void setQuinta(Boolean quinta) {
		this.quinta = quinta;
	}

	public Boolean getSexta() {
		return sexta;
	}

	public void setSexta(Boolean sexta) {
		this.sexta = sexta;
	}

	public Boolean getSabado() {
		return sabado;
	}

	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}

	public Boolean getNotificar_resp() {
		return notificar_resp;
	}

	public void setNotificar_resp(Boolean notificar_resp) {
		this.notificar_resp = notificar_resp;
	}

	public Boolean getNotificar_prof() {
		return notificar_prof;
	}

	public void setNotificar_prof(Boolean notificar_prof) {
		this.notificar_prof = notificar_prof;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Date getCreate_time() {
		return create_time;
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
		RegistroSaida other = (RegistroSaida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

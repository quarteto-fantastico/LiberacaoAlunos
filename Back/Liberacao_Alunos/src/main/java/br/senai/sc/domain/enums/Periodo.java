package br.senai.sc.domain.enums;

public enum Periodo {
	
	MATUTINO (1, "Matutino"),
	VESPERTINO(2, "Vespertino"),
	DIURNO(3,"Diurno"),
	NOTURNO(4,"Noturno");
	
	private Integer codigo;
	private String descricao;
	
	
	private Periodo(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static Periodo toEnum(Integer codigo) {
		for (Periodo periodo : Periodo.values()) {
			if(periodo.getCodigo() == codigo) {
				return periodo;
			}
		}
		return null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	
}

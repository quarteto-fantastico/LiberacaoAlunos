package br.senai.sc.domain.enums;


public enum Perfil {
	GUARDA(1, "ROLE_GUARDA"),
	PROFESSOR(2, "ROLE_PROFESSOR"),
	ADMINISTRADOR(3, "ROLE_ADMINISTRADOR");

	private int codigo;
	private String descricao;

	private Perfil(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Perfil toEnum(Integer codigo) {
		if (codigo == null) return null;
		
		for (Perfil tipo : Perfil.values()) {
			if (codigo.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: " + codigo);
	}

}

package br.com.unialfa.aula.enumerator;

public enum SexoEnum {
	MASCULINO(1L, "Masculino", "M"), FEMININO(2L, "Feminino", "F");

	private Long id;
	private String descricao;
	private String sigla;

	private SexoEnum(Long id, String descricao, String sigla) {
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getSigla() {
		return sigla;
	}
	
	@Override
	public String toString() {
		return descricao;
	}

}

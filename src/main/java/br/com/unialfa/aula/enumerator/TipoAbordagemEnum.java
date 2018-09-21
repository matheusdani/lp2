package br.com.unialfa.aula.enumerator;

public enum TipoAbordagemEnum {
	ANALISE_DO_COMPORTAMENTO(1L, "Analise do comportamento"),
	AVALIACAO_NEUROPSICOLOGICA(2L, "Avaliação do neuropsicologica"), COMPORTAMENTO(3L, "Avaliação comportametal"),
	CONGNICAO_COMPORTAMENTAL(4L, "Cognição comportamental"), GESTALT(5L, "Gestalt"), PSICANALISE(6L, "Psicanalise"),
	PSICODIAGNOSTICO(7L, "Psicodiadnóstico");

	private Long id;
	private String descricao;

	private TipoAbordagemEnum(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}

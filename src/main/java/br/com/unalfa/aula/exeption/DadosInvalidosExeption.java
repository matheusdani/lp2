package br.com.unalfa.aula.exeption;

import br.com.unialfa.aula.Utils.Utils;

public class DadosInvalidosExeption extends RegraDeNegocioExeption {
	private static final long serialVersionUID = 1L;
	
	public DadosInvalidosExeption(String message) {
		Utils.showMessageError("Dados invalidos");
		Utils.showMessageError(message);
	}
	
	public DadosInvalidosExeption() {
		super();
	}

}

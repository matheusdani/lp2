package br.com.unalfa.aula.exeption;

import java.util.Locale;
import java.util.ResourceBundle;

public class RegraDeNegocioExeption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RegraDeNegocioExeption(String message) {
		super(message);
	}
	
	public RegraDeNegocioExeption() {
		super();
	}

	@Override
	public String getMessage() {
		ResourceBundle resource = ResourceBundle
				.getBundle("messages", new Locale("pt","BR"));
		String msg = resource.getString(getClass().getSimpleName());
		return msg;
	}
}

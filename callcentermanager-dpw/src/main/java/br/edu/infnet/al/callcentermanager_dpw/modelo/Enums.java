package br.edu.infnet.al.callcentermanager_dpw.modelo;

public class Enums {

	public static enum status {
		CADASTRADO,
		EM_ATENDIMENTO,
		FINALIZADO
	}
	
	public static enum resultado {
		CANCELADO,
		CONSERTADO,
		SEM_SOLUCAO
	}
	
	public static enum erros {
		NOME_INVALIDO,
		CPF_INVALIDO,
		EMAIL_INVALIDO,
		ENDERECO_INVALIDO,
		
	}
}

package br.edu.infnet.al.callcenterdpw.dto;

public class Enums {

	public static enum statusChamado {
		CADASTRADO,
		EM_ATENDIMENTO,
		FINALIZADO
	}
	
	public static enum resultadoChamado {
		CANCELADO,
		CONSERTADO,
		SEM_SOLUCAO
	}
	
	public static enum erros {
		NOME_INVALIDO,
		CPF_INVALIDO,
		EMAIL_INVALIDO,
		ENDERECO_INVALIDO,
		TELEFONE_INVALIDO
	}
}

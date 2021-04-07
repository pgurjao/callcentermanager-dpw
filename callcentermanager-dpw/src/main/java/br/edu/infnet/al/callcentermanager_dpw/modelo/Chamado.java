package br.edu.infnet.al.callcentermanager_dpw.modelo;

public class Chamado {

	private int idChamado;
	private Cliente cliente;
//	private int idCliente; // Colocar o objeto Cliente ou apenas o idCliente associado ao chamado?
	private int idProduto;
//	private Produto produto; // Colocar o objeto Produto ou apenas o idProduto associado ao chamado?
	private int numeroSerieProduto; //Colocar numero de serie do produto no chamado ou deixar pra pegar direto do objeto Produto? 
	private String descricaoResumida;
	private String detalhamentoCompleto;
	private int codigoErro;
	private enum Status {
						CADASTRADO,
						EM_ATENDIMENTO,
						FINALIZADO
						}
	private enum Resultado {
							CANCELADO,
							CONSERTADO,
							SEM_SOLUCAO
							}
	
	
	
}

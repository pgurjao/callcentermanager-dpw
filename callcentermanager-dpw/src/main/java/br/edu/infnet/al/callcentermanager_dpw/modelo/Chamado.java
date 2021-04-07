package br.edu.infnet.al.callcentermanager_dpw.modelo;

public class Chamado {

	private int idChamado;
	private Cliente cliente;
//	private int idCliente; // Colocar o objeto Cliente ou apenas o idCliente associado ao chamado?
	private Produto produto; 
//	private int idProduto; // Colocar o objeto Produto ou apenas o idProduto associado ao chamado?
	private int numeroSerieProduto; //Colocar numero de serie do produto no chamado ou deixar pra pegar direto do objeto Produto? 
	private String descricaoResumida;
	private String detalhamentoCompleto;
	private int codigoErro;
	private String status;
	private String resultado;
	
	public Chamado(Cliente cliente, Produto produto, String descricaoResumida) {
		this.cliente = cliente;
		this.produto = produto;
		this.descricaoResumida = descricaoResumida;
	}
	
	public boolean cadastrarChamado (Chamado chamado) {
		
		return true;
	}
	
	public boolean consultarChamado (int idChamado) {
		
		return true;
	}
	
	public boolean reativarChamado (Chamado chamado) {
		
		return true;
	}

	public int getIdChamado() {
		return idChamado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getNumeroSerieProduto() {
		return numeroSerieProduto;
	}

	public String getDescricaoResumida() {
		return descricaoResumida;
	}

	public String getDetalhamentoCompleto() {
		return detalhamentoCompleto;
	}

	public int getCodigoErro() {
		return codigoErro;
	}
	
}

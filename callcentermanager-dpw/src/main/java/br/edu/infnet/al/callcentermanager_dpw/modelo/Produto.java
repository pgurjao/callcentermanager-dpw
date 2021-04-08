package br.edu.infnet.al.callcentermanager_dpw.modelo;

public class Produto {
	
	private int idProduto;
	private String nome;
	private int numeroSerie;

	public Produto(String nome) {
		this.nome = nome;
	}

	public Produto(int numeroSerie, String nome) {
		this.numeroSerie = numeroSerie;
		this.nome = nome;
	}
	
	public boolean adicionarSolucao (Solucao solucao) {
		
		return true;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

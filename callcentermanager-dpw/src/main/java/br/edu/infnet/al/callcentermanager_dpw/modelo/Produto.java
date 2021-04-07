package br.edu.infnet.al.callcentermanager_dpw.modelo;

public class Produto {
	
	private int idProduto;
	private int numeroSerie;
	private String nome;

	public Produto(String nome) {
		this.nome = nome;
	}

	public Produto(int numeroSerie, String nome) {
		this.numeroSerie = numeroSerie;
		this.nome = nome;
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

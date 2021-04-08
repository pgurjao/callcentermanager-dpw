package br.edu.infnet.al.callcentermanager_dpw.modelo;

public class Solucao {
	
	private int idSolucao;
	private String titulo;
	private String detalhamentoCompleto;
	
	public Solucao(String titulo, String detalhamentoCompleto) {
		this.titulo = titulo;
		this.detalhamentoCompleto = detalhamentoCompleto;
	}

	public int getIdSolucao() {
		return idSolucao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDetalhamentoCompleto() {
		return detalhamentoCompleto;
	}
	
	

}

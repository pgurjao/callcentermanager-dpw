package br.edu.infnet.al.callcenterdpw.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="solucao")
public class SolucaoDTO {
	
	@Id
	@GeneratedValue
	private long idSolucao;
	private String titulo;
	private String detalhamentoCompleto;
	
	public SolucaoDTO() {
		
	}

	public SolucaoDTO(long idSolucao, String titulo, String detalhamentoCompleto) {
		super();
		this.idSolucao = idSolucao;
		this.titulo = titulo;
		this.detalhamentoCompleto = detalhamentoCompleto;
	}

	public long getIdSolucao() {
		return idSolucao;
	}

	public void setIdSolucao(long idSolucao) {
		this.idSolucao = idSolucao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhamentoCompleto() {
		return detalhamentoCompleto;
	}

	public void setDetalhamentoCompleto(String detalhamentoCompleto) {
		this.detalhamentoCompleto = detalhamentoCompleto;
	}
	
}

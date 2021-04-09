package br.edu.infnet.al.callcenterdpw.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class ProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idProduto;
	private String nome;
	private int numeroSerie;
	
	public ProdutoDTO() {
		
	}

	public ProdutoDTO(long idProduto, String nome, int numeroSerie) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.numeroSerie = numeroSerie;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}	

}

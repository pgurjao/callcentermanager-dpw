package br.edu.infnet.al.callcenterdpw.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="produto")
public class ProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long idProduto;
	@NonNull
	private String nome;
	@NonNull
	private int numeroSerie;
	
	public ProdutoDTO() {
		
	}

	public ProdutoDTO(long idProduto, String nome, int numeroSerie) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.numeroSerie = numeroSerie;
	}
	
	public boolean validarNome (String nome) {

		if(nome.length() >= 3) {
			return true;
		}

		return false;
	}
	
	public boolean validarNumeroSerie (int numeroSerie) {

		if(numeroSerie > 0) {
			return true;
		}
		
		return false;
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

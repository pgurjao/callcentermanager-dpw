package br.edu.infnet.al.callcentermanager_dpw.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String endereco;
	private int idCliente;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

	public boolean cadastrarCliente (String nome, String cpf, String email) {
		
		return true;
	}
	
	public boolean editarCliente (String cpf) {
		
		return true;
	}
	
	public boolean adicionarContrato (String cpf, int idContrato) {
		
		return true;
	}
	
	public boolean adicionarProduto (String cpf, int numeroSerie) {
		
		return true;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

}

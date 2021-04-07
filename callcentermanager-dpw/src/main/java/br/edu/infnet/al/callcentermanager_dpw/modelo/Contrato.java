package br.edu.infnet.al.callcentermanager_dpw.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private int idContrato;
	private String descricao;
	private Date validade;
	private int nivelPrioridade;
//	private List<Integer> idProdutos = new ArrayList<Integer>(); // Devemos detalhar que produtos o contrato se aplica? Pensei em fazer uma lista de int com os idProduto que o contrato incluiria.

	public boolean alterarValidade (Date novoVencimento) {
		
		return true;
	}
	
	public boolean alterarPrioridade (int nivelPrioridade) {

		return true;
	}

	public int getIdContrato() {
		return idContrato;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getValidade() {
		return validade;
	}

	public int getNivelPrioridade() {
		return nivelPrioridade;
	}
	
}

package br.edu.infnet.al.callcentermanager_dpw.modelo;

import java.util.ArrayList;
import java.util.List;

public class Fila {
	
	private List<Chamado> chamados = new ArrayList<Chamado>();
	
	public List<Chamado> exibirFila () {
		
		return chamados; 
	}
	
	public void adicionarChamado (Chamado chamado) {
		
//		 chamados.add(chamado); //  ETC ETC...
		
	}
	
	public void ordenarFila () {
		
	}
	
	public void furarFila (Chamado chamado) {
		
//		 chamados.add(0, chamado); // coloca "chamado" na posição 0 da lista
		
	}

}

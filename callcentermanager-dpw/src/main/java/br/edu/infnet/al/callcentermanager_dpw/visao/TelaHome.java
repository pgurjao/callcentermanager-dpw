package br.edu.infnet.al.callcentermanager_dpw.visao;

import java.util.Scanner;

public class TelaHome {

	public void apresentar () {
		
		int opcao = 0;
		
		while (opcao >= 1 && opcao <= 3 ) {
			
			System.out.println("=== Menu de Opcoes ===");
			System.out.println();
			System.out.println("1- Cadastrar cliente");
			System.out.println("2- Adicionar produto");
			System.out.println("3- Sair");
			System.out.println("");
			System.out.println("Digite a opcao desejada: ");
			
			Scanner scanner = new Scanner(System.in);
			
			scanner.nextInt(opcao);
		}
		
		switch (opcao) {
		case 1:
			TelaCliente telaCliente = new TelaCliente ();
			telaCliente.cadastrar();
			break;
		case 2:
			
			break;

		default:
			System.out.println("ERRO: opcao invalida");
			break;
		}
		
	}
	
}

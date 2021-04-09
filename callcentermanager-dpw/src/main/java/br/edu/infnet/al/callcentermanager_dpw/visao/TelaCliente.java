package br.edu.infnet.al.callcentermanager_dpw.visao;

import java.util.Scanner;

public class TelaCliente {
	
	public void cadastrar () {
		
		String nome;
		String cpf;
		String email;
		String telefone;
		String endereco;
		int idContrato;
		String opcao = "n";
		Scanner scanner = new Scanner(System.in);
		
		
		while (!opcao.equalsIgnoreCase("s") )
		
		System.out.println("=== Tela Cadastrar Cliente ===\n");
		
		System.out.print("Digite o nome do cliente: ");
		nome = scanner.nextLine();
		
		System.out.print("\nDigite o CPF do cliente: ");
		cpf = scanner.nextLine();
		
		System.out.print("\nDigite o email do cliente: ");
		email = scanner.nextLine();
		
		System.out.print("\nDigite o telefone do cliente: ");
		telefone = scanner.nextLine();
		
		System.out.print("\nDigite o endereco do cliente: ");
		endereco = scanner.nextLine();
		
		System.out.print("\nDigite o ID do contrato (se houver): ");
		idContrato = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("\nAs informacoes digitadas estao corretas e deseja continuar (s/n)? ");
		opcao = scanner.nextLine();
	}
	
}

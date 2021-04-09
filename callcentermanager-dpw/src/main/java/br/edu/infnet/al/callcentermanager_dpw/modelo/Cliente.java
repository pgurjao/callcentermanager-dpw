package br.edu.infnet.al.callcentermanager_dpw.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String endereco;
	private Contrato contrato;
	private int idContrato;
//	private List<Contrato> contratos = new ArrayList<Contrato>(); // Como associar o cliente ao contrato? Colocando o objeto Contrato como atributo, apenas o idContrato ou fazer uma lista de contratos? 
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

	public Cliente() {
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
	
	public boolean validaCpf(String cpf) {
		
		String caracteresValidos = "0123456789.-";
		
//		System.out.println("\n---------- Testando CPF: " + cpf);
		
		if (cpf.length() > 14) {
//			System.out.println("CPF INVALIDO! (L>14)");
			return false;
		}
		
		for (char c : cpf.toCharArray() ) {
			if (caracteresValidos.indexOf(c) == -1 ) {
//				System.out.println("CPF INVALIDO! (invalid char) ");
				return false;
			}
		}
		
		if (cpf.indexOf(".") == 0 || cpf.indexOf("-") == 0
				|| cpf.indexOf(".") == cpf.length() - 1
				|| cpf.indexOf("-") == cpf.length() - 1 ) {
//			System.out.println("CPF INVALIDO! (invalid format) ");
			return false;
		}
		
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
	
		if (cpf.length() < 11) {
			while (cpf.length() < 11) {
				cpf = "0" + cpf;
			}
		} else {
			if (cpf.length() > 11) {
//				System.out.println("CPF INVALIDO! (L>11)");
				return false;
			}
		}
		
		boolean todosDigitosRepetidos = false;
		int contador = 0; 
		
		char algarismoCpf = '0';
		
		do {
			contador = 0;
			for (char c : cpf.toCharArray() ) {
				if (c == algarismoCpf ) {
					todosDigitosRepetidos = true;
					contador++;
				} else {
					todosDigitosRepetidos = false;
				}
			}
			if (todosDigitosRepetidos == true && contador == 11) {
//				System.out.println("CPF INVALIDO! (todosDigitosRepetidos)");
				return false;
			}
			algarismoCpf = (char) (algarismoCpf + 1);
		} while (algarismoCpf != ':');
		
		// String cpf sanitizada
		
		int multiplicador = 2;
		int[] produtosMultiplicacao = new int[11];
		int[] resultado = new int[11];
		contador = 0;
		
		for (char c : cpf.toCharArray() ) {
			resultado[contador] = Character.getNumericValue(c);
			contador++;
		}
		
		contador = 0;
		
		for (int i = 8; i >= 0 ; i--) {
			produtosMultiplicacao[i] = resultado[i] * multiplicador;
			multiplicador++;
		}
		
		int soma = 0;
		for (int i = 0; i < 9 ; i++ ) {
			soma = produtosMultiplicacao[i] + soma; 
		}
//		System.out.println("soma1 = " + soma);
		
		//Digito verificador 1
		if ( soma % 11 < 2 ) {
			resultado[9] = 0;
		} else {
			resultado[9] = 11 - (soma % 11);
		}
//		System.out.println("Digito 1 = " + resultado[9]);
		
		multiplicador = 2;
		for (int i = 9; i >= 0 ; i--) {
			produtosMultiplicacao[i] = resultado[i] * multiplicador;
			multiplicador++;
		}
		
		soma = 0;
		for (int i = 0; i < 10 ; i++ ) {
			soma = produtosMultiplicacao[i] + soma; 
		}
		
//		System.out.println("\nsoma2 = " + soma);
		
		//Digito verificador 2
		if ( soma % 11 < 2 ) {
			resultado[10] = 0;
		} else {
			resultado[10] = 11 - (soma % 11);
		}
//		System.out.println("Digito 2 = " + resultado[10] + "\n");
		
//		System.out.println("CPF              = " + cpf.substring(0, 9) + "-" + cpf.substring(9, 11) );
//		System.out.print("CPF calculado    = " + Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "").substring(0, 9) + "-" + Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "").substring(9, 11) );
		
//		System.out.println("");

		if (cpf.equalsIgnoreCase(Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "") ) ) {
//			System.out.println("CPF VALIDADO COM SUCESSO!");
			return true;
		} else {
//			System.out.println("CPF INVALIDO! (digito verificador) ");
			return false;
		}
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

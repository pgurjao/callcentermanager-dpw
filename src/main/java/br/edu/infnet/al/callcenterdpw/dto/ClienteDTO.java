package br.edu.infnet.al.callcenterdpw.dto;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long idCliente;
	private Long idContrato;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String endereco;
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="idContrato", referencedColumnName="idContrato", insertable=false, updatable=false)
	private ContratoDTO contrato;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(long idCliente, String nome, String cpf, String email, String telefone, String endereco,
			long idContrato) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.idContrato = idContrato;
	}
	
	public boolean validarCpf(String cpf) {
		
		String caracteresValidos = "0123456789.-";
		
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
		
		// retira '.' e '-' e deixa soh os numeros
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
	
		// se o tamanho eh menor que 11 numeros, acrescenta os zeros a esquerda
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
		
		// String cpf validada, pronto para calcular digitos verificadores
		
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
		
		//Digito verificador 1
		if ( soma % 11 < 2 ) {
			resultado[9] = 0;
		} else {
			resultado[9] = 11 - (soma % 11);
		}
		
		multiplicador = 2;
		for (int i = 9; i >= 0 ; i--) {
			produtosMultiplicacao[i] = resultado[i] * multiplicador;
			multiplicador++;
		}
		
		soma = 0;
		for (int i = 0; i < 10 ; i++ ) {
			soma = produtosMultiplicacao[i] + soma; 
		}
		
		//Digito verificador 2
		if ( soma % 11 < 2 ) {
			resultado[10] = 0;
		} else {
			resultado[10] = 11 - (soma % 11);
		}
		
//		System.out.println("CPF              = " + cpf.substring(0, 9) + "-" + cpf.substring(9, 11) );
//		System.out.print("CPF calculado    = " + Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "").substring(0, 9) + "-" + Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "").substring(9, 11) );

		if (cpf.equalsIgnoreCase(Arrays.toString(resultado).replaceAll("\\[|\\]|,|\\s", "") ) ) {
//			System.out.println("CPF VALIDADO COM SUCESSO!");
			return true;
		} else {
//			System.out.println("CPF INVALIDO! (digito verificador invalido) ");
			return false;
		}
	}
	
	public boolean validarNome (String nome) {

		if(nome.length() >= 3) {
			return true;
		}

		return false;
	}

	public boolean validarTelefone (String telefone) {

		Long numTelefone = null;
		long telefoneMinimo = 1120000000L;
		long telefoneMaximo = 99999999999L;
		
		try {
			numTelefone = Long.parseLong(telefone);
		} catch (NumberFormatException e) {
			return false;
		} finally {
			if (numTelefone != null) {
				if (numTelefone >= telefoneMinimo && numTelefone <= telefoneMaximo ) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean validarEndereco (String endereco) {

		if (endereco.length() >= 5) {
			return true;
		}
		return false;
	}
	
	public boolean validarEmail (String email) {

		email = email.strip();
		
		if (email.length() >= 5 ) {
			if (email.indexOf('@') == email.lastIndexOf('@') && email.indexOf('@') > 0 ) {
				if (email.lastIndexOf('.') - email.lastIndexOf('@') > 1 ) {
					if (email.charAt(email.length()-1 ) != '.' ) {
						if (email.charAt(email.lastIndexOf('@') - 1 ) != '.' ) {
							if (email.charAt(email.lastIndexOf('@') + 1 ) != '.' ) {
								if (email.charAt(0) != '.')
									return true;
							}
						}
					}
				}
			}
		} 
		return false;		
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getIdContrato() {
		return idContrato;
	}
	
}

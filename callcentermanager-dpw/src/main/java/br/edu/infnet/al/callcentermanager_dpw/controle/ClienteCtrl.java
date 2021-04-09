package br.edu.infnet.al.callcentermanager_dpw.controle;

import java.util.IllegalFormatException;

import br.edu.infnet.al.callcentermanager_dpw.modelo.Cliente;
import br.edu.infnet.al.callcentermanager_dpw.modelo.Enums;

public class ClienteCtrl {
	
	private String status = "";
	private Cliente cliente = new Cliente ();

	public boolean cadastrarCliente (String nome, String cpf, String email, String telefone, String endereco, int idContrato) {

		
		if (!validarNome(nome) ) {
			status = Enums.erros.NOME_INVALIDO.toString();
			return false;
		}
		
		if (!validarCpf(cpf) ) {
			status = Enums.erros.CPF_INVALIDO.toString();
			return false;
		}
		
		if (!validarEmail(email) ) {
			status = Enums.erros.EMAIL_INVALIDO.toString();
			return false;
		}

		if (!validarTelefone(telefone) ) {
			status = Enums.erros.EMAIL_INVALIDO.toString();
			return false;
		}
		
		if (!validarEndereco(endereco) ) {
			status = Enums.erros.EMAIL_INVALIDO.toString();
			return false;
		}
		
		// incluir no banco de dados

		return true;
	}

	private boolean validarNome (String nome) {

		if(nome.length() >= 3) {
			return true;
		}
		
		return false;
	}

	private boolean validarCpf (String cpf) {
		
		return cliente.validaCpf(cpf);
	}
	
	private boolean validarEmail (String email) {
		
		if(email.length() >= 6) {
			if (email.indexOf('@') == email.lastIndexOf('@')  ) {
				return true;
			}
		}
		return false;
	}
	
	private boolean validarTelefone (String telefone) {
		
		int numTelefone = Integer.parseInt(telefone);
		
		if (numTelefone >= 1120000000) {
			return true;
		}
		return false;
	}
	
	private boolean validarEndereco (String endereco) {
		
		if (endereco.length() >= 5) {
			return true;
		}
		return false;
	}

}

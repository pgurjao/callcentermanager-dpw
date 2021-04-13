package br.edu.infnet.al.callcenterdpw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.callcenterdpw.dto.ClienteDTO;
import br.edu.infnet.al.callcenterdpw.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;

	public List<ClienteDTO> getAll() {
		return (List<ClienteDTO>) clienteRepository.findAll();
	}

	public ClienteDTO save(ClienteDTO cliente) {

		if (cliente == null) {
			return null;
		}

		return clienteRepository.save(cliente);
	}

	public boolean checkIfCpfExists(String cpfClienteNovo) {

		List<ClienteDTO> clienteList = new ArrayList<ClienteDTO>();
		String cpfDaLista;
		
		cpfClienteNovo = cpfClienteNovo.strip();
		cpfClienteNovo  = cpfClienteNovo.replace(".", "");
		cpfClienteNovo = cpfClienteNovo.replace("-", "");
		
		clienteList  = this.getAll();
		
		for (ClienteDTO cDto : clienteList) {
			
			cpfDaLista = cDto.getCpf().strip();
			cpfDaLista = cpfDaLista.replace(".", "");
			cpfDaLista = cpfDaLista.replace("-", "");
			
			if (cpfClienteNovo.equalsIgnoreCase(cpfDaLista) ) {
				return true;
			}
		}

		return false;
	}

	public boolean checkIfEmailExists(String emailClienteNovo) {
		
		List<ClienteDTO> clienteList = new ArrayList<ClienteDTO>();
		String emailDaLista;
		
		clienteList  = this.getAll();
		
		for (ClienteDTO cDto : clienteList) {
			
			emailDaLista = cDto.getEmail();
			if (emailDaLista.equalsIgnoreCase(emailClienteNovo) ) {
				return true;
			}
		}
		
		return false;
	}

	public boolean checkIfTelefoneExists(String telefoneClienteNovo) {
		
		List<ClienteDTO> clienteList = new ArrayList<ClienteDTO>();
		String telefoneDaLista;
		
		clienteList  = this.getAll();
		
		for (ClienteDTO cDto : clienteList) {
			
			telefoneDaLista = cDto.getTelefone();
			if (telefoneDaLista.equalsIgnoreCase(telefoneClienteNovo) ) {
				return true;
			}
		}
		
		return false;
	}

	public Optional<ClienteDTO> getById(Long id) {
		return clienteRepository.findById(id);
	}
	
}

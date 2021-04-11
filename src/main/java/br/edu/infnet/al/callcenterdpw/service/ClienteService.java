package br.edu.infnet.al.callcenterdpw.service;

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
		public Optional<ClienteDTO> getById(Long id) {
			return clienteRepository.findById(id);
		}

}

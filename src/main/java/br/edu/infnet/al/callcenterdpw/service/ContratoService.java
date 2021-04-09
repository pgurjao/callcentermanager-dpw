package br.edu.infnet.al.callcenterdpw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.infnet.al.callcenterdpw.dto.ContratoDTO;
import br.edu.infnet.al.callcenterdpw.repository.ContratoRepository;

public class ContratoService {
	
	@Autowired
	public ContratoRepository contratoRepository;
	
	public List<ContratoDTO> getAll() {
		return (List<ContratoDTO>)contratoRepository.findAll();
	}

	public ContratoDTO save(ContratoDTO contrato) {
		return contratoRepository.save(contrato);
	}

	//Optional porque o retorno pode ser nulo 
	public Optional<ContratoDTO> getById(Long id) {
		return contratoRepository.findById(id);
	}
}

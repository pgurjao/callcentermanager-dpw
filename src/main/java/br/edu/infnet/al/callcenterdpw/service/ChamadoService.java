package br.edu.infnet.al.callcenterdpw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.callcenterdpw.dto.ChamadoDTO;
import br.edu.infnet.al.callcenterdpw.repository.ChamadoRepository;


@Service
public class ChamadoService {
	@Autowired
	public ChamadoRepository chamadoRepository;
	
	public List<ChamadoDTO> getAll() {
		return (List<ChamadoDTO>)chamadoRepository.findAll();
	}

	public ChamadoDTO save(ChamadoDTO chamado) {
		return chamadoRepository.save(chamado);
	}

	//Optional porque o retorno pode ser nulo 
	public Optional<ChamadoDTO> getById(Long id) {
		return chamadoRepository.findById(id);
	}

}

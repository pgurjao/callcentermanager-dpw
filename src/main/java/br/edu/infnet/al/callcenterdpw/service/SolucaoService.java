package br.edu.infnet.al.callcenterdpw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.callcenterdpw.dto.SolucaoDTO;
import br.edu.infnet.al.callcenterdpw.repository.SolucaoRepository;

@Service
public class SolucaoService {
	
	@Autowired
    public SolucaoRepository solucaoRepository;

    public List<SolucaoDTO> getAll() {
        return (List<SolucaoDTO>)solucaoRepository.findAll();
    }

    public SolucaoDTO save(SolucaoDTO solucao) {
        return solucaoRepository.save(solucao);
    }

    public Optional<SolucaoDTO> getById(Long id) {
        return solucaoRepository.findById(id);
    }

}

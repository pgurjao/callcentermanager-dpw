package br.edu.infnet.al.callcenterdpw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.al.callcenterdpw.dto.ProdutoDTO;
import br.edu.infnet.al.callcenterdpw.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
    public ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getAll() {
        return (List<ProdutoDTO>)produtoRepository.findAll();
    }

    public ProdutoDTO save(ProdutoDTO produto) {
        return produtoRepository.save(produto);
    }

    public Optional<ProdutoDTO> getById(Long id) {
        return produtoRepository.findById(id);
    }
	
}

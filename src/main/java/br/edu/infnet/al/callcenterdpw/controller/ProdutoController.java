package br.edu.infnet.al.callcenterdpw.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.al.callcenterdpw.dto.ProdutoDTO;
import br.edu.infnet.al.callcenterdpw.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> getProduto() {
        return produtoService.getAll();
    }

    @PostMapping
    public ProdutoDTO salvaProduto(@RequestBody ProdutoDTO produto) {
        return produtoService.save(produto);
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProduto(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = produtoService.getById(id);

        if(produto.isEmpty()) return null;

        return produto.get();
    }

}

package br.edu.infnet.al.callcenterdpw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

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
    public ProdutoDTO salvaProduto(@RequestBody ProdutoDTO produto, HttpServletResponse response) {
    	
    	String erro = null;
    	int erroNum = 406;
    	
    	if (!produto.validarNome(produto.getNome() ) )
    		erro = "Nome invalido, deve ter no minimo 3 caracteres";
    	
    	if (!produto.validarNumeroSerie(produto.getNumeroSerie() ) )
    		erro = "Numero de serie invalido, deve ser um numero maior que zero";
    	
    	if (erro == null ) {
//    		System.out.println("Dados cliente sao validos, salvando...");
    		return produtoService.save(produto);
    	}
    	
    	response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
    	
    	try {
			response.sendError(erroNum, erro);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProduto(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = produtoService.getById(id);

        if(produto.isEmpty()) return null;

        return produto.get();
    }

}

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

import br.edu.infnet.al.callcenterdpw.dto.SolucaoDTO;
import br.edu.infnet.al.callcenterdpw.service.SolucaoService;


@RestController
@RequestMapping("/solucao")
public class SolucaoController {
	
	@Autowired
    private SolucaoService solucaoService;

    @GetMapping
    public List<SolucaoDTO> getSolucao() {
        return solucaoService.getAll();
    }

    @PostMapping
    public SolucaoDTO salvaSolucao(@RequestBody SolucaoDTO solucao, HttpServletResponse response) {
        
    	String erro = null;
    	int erroNum = 406;
    	
    	if (!solucao.validarTitulo(solucao.getTitulo() ) )
    		erro = "Titulo invalido, deve ter no minimo 4 caracteres";
    	
    	if (!solucao.validarDetalhamentoCompleto(solucao.getDetalhamentoCompleto() ) )
    		erro = "Detalhamento invalido, deve ter no minimo 5 caracteres";
    	
    	if (erro == null ) {
//    		System.out.println("Dados cliente sao validos, salvando...");
    		return solucaoService.save(solucao);
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
    public SolucaoDTO getSolucao(@PathVariable Long id) {
        Optional<SolucaoDTO> solucao = solucaoService.getById(id);

        if(solucao.isEmpty()) return null;

        return solucao.get();
    }

}

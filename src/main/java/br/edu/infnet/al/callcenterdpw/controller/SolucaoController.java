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
    public SolucaoDTO salvaSolucao(@RequestBody SolucaoDTO solucao) {
        return solucaoService.save(solucao);
    }

    @GetMapping("/{id}")
    public SolucaoDTO getSolucao(@PathVariable Long id) {
        Optional<SolucaoDTO> solucao = solucaoService.getById(id);

        if(solucao.isEmpty()) return null;

        return solucao.get();
    }

}

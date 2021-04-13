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

import br.edu.infnet.al.callcenterdpw.dto.ChamadoDTO;
import br.edu.infnet.al.callcenterdpw.dto.Enums;
import br.edu.infnet.al.callcenterdpw.service.ChamadoService;


@RestController
@RequestMapping("/chamado")
public class ChamadoController {
	
	@Autowired
	private ChamadoService chamadoService;
	
	//consultar todos os chamados
	@GetMapping
	public List<ChamadoDTO> getChamado() {
		return chamadoService.getAll();
	}
	
	
	//adicionar chamados
    @PostMapping
    public ChamadoDTO salvarChamado(@RequestBody ChamadoDTO chamado) {
        
    	chamado.setStatus(Enums.statusChamado.CADASTRADO.toString() );
    	
    	return chamadoService.save(chamado);
    }
    
    
    //pesquisar chamados por id
    @GetMapping("/{id}")
    public ChamadoDTO getChamado(@PathVariable Long id) {
        Optional<ChamadoDTO> chamado = chamadoService.getById(id);

        if(chamado.isEmpty()) return null;

        return chamado.get();
    }

    //reativar chamadoo
    public ChamadoDTO reativarChamado(@PathVariable Long id) {
    	return chamadoService.reOpen(id);
    }
}

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

import br.edu.infnet.al.callcenterdpw.dto.ContratoDTO;
import br.edu.infnet.al.callcenterdpw.service.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoService contratoService;
	
	//buscar todos
	@GetMapping
	public List<ContratoDTO> getContrato() {
		return contratoService.getAll();
	}
	
	//salvar
	@PostMapping
    public ContratoDTO salvarContrato(@RequestBody ContratoDTO contrato) {
        return contratoService.save(contrato);
    }
	
	//buscar por id
    @GetMapping("/{id}")
    public ContratoDTO getContrato(@PathVariable Long id) {
        Optional<ContratoDTO> contrato = contratoService.getById(id);

        if(contrato.isEmpty()) return null;

        return contrato.get();
    }

}

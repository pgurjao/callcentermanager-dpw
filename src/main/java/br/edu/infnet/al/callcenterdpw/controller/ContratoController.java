package br.edu.infnet.al.callcenterdpw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
    public ContratoDTO salvarContrato(@Valid @RequestBody ContratoDTO contrato, HttpServletResponse response) {
		
    	try {
			
		} catch (HttpMessageNotReadableException e) {
			System.out.println("erro conversao de data");
		}
		
		String erro = null;
    	int erroNum = 406;
		
		if (!contrato.validarCpf(contrato.getCpf() ) )
    		erro = "CPF invalido";
		
//		if (!contrato.validarDescricao(contrato.getDescricao() ) )
//    		erro = "Descricao invalida, deve conter 3 ou mais caracteres";
		
		if (!contrato.validarNivelPrioridade(contrato.getNivelPrioridade() ) )
    		erro = "Nivel de prioridade invalido, deve ser um numero inteiro igual ou maior que 0";
		
		if (erro == null ) {
//    		System.out.println("Dados cliente sao validos, salvando...");
			return contratoService.save(contrato);
    	}
    	
    	response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
    	
    	try {
			response.sendError(erroNum, erro);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }
	
	//buscar por id
    @GetMapping("/{id}")
    public ContratoDTO getContrato(@PathVariable Long id) {
        Optional<ContratoDTO> contrato = contratoService.getById(id);

        if(contrato.isEmpty()) return null;

        return contrato.get();
    }

    
    
}

package br.edu.infnet.al.callcenterdpw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.al.callcenterdpw.dto.ClienteDTO;
import br.edu.infnet.al.callcenterdpw.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> getCliente() {
		return clienteService.getAll();
	}
	
    @PostMapping
    public ClienteDTO salvarCliente(@RequestBody ClienteDTO cliente, HttpServletResponse response) {
    	
    	ClienteDTO cDto = new ClienteDTO();
    	String erro = null;
    	int erroNum = 406;
    	
    	if (!cDto.validarCpf(cliente.getCpf() ) )
    		erro = "CPF invalido";
    	
    	if (!cDto.validarNome(cliente.getNome() ) )
    		erro = "Nome invalido, deve possuir pelo menos 3 caracteres";
    	
    	if (!cDto.validarEmail(cliente.getEmail() ) )
    		erro = "Email invalido, deve ser no formato *@*.*";
    	
    	if (!cDto.validarTelefone(cliente.getTelefone() ) )
    		erro = "Telefone invalido, deve conter apenas numeros e ser no formato DDD (2 numeros) + telefone (8 ou 9 numeros). Exemplo: 1123450001 ou 11998763344";
    	
    	if (!cDto.validarEndereco(cliente.getEndereco() ) )
    		erro = "Endereco invalido, deve possuir pelo menos 5 caracteres";
    	
    	if (erro == null ) {
//    		System.out.println("Dados cliente sao validos, salvando...");
    		return clienteService.save(cliente);
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
    public ClienteDTO getCliente(@PathVariable Long id) {
        Optional<ClienteDTO> cliente = clienteService.getById(id);

        if(cliente.isEmpty()) return null;

        return cliente.get();
    }
    
//    @RequestMapping(value = "/controller", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity sendViaResponseEntity() {
//        return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
//    }


}
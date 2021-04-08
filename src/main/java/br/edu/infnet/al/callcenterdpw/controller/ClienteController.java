package br.edu.infnet.al.callcenterdpw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ClienteDTO salvarCliente(@RequestBody ClienteDTO cliente) {
        return clienteService.save(cliente);
    }


}

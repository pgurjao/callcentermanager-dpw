package br.edu.infnet.al.callcenterdpw.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.al.callcenterdpw.dto.ClienteDTO;

public interface ClienteRepository extends CrudRepository<ClienteDTO,Long>{

}

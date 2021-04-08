package br.edu.infnet.al.callcenterdpw.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.al.callcenterdpw.dto.ProdutoDTO;

public interface ProdutoRepository extends CrudRepository<ProdutoDTO,Long> {

}

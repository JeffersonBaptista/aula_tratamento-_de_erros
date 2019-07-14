package com.br.produto.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoModelRepository extends CrudRepository<ProdutoModel, Integer>{
	

}

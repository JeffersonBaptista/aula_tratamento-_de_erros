package com.br.produto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.produto.models.ProdutoModel;
import com.br.produto.models.ProdutoModelRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoModelRepository produtoModelRepository;
	
	public void cadastrarProduto(ProdutoModel produto) {
		produtoModelRepository.save(produto);
		
	}
	
	public Iterable<ProdutoModel> exibirProdutos(){
		return produtoModelRepository.findAll();
	}	
	
	public void deletarProduto(int id) {
		produtoModelRepository.deleteById(id);
	}


}

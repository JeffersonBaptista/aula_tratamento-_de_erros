package com.br.produto.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.produto.models.ProdutoModel;
import com.br.produto.services.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/")
	public ModelAndView exibirProdutos() {
		ModelAndView modelAndView = new ModelAndView("produtos.html");
		modelAndView.addObject("produtos", produtoService.exibirProdutos());
		return modelAndView;

	}

	@PostMapping("/")
	public ModelAndView cadastrarProduto(@Valid ProdutoModel produto, BindingResult bindingResult) {
		ModelAndView modelAnsView = new ModelAndView("produtos.html");

		List<String> erros = new ArrayList<String>();
		List<String> mensagens = new ArrayList<String>();

		if (bindingResult.hasErrors()) {

			for (ObjectError objectErros : bindingResult.getAllErrors()) {
				erros.add(objectErros.getDefaultMessage());
			}
			modelAnsView.addObject("erros", erros);

		} else {
			produtoService.cadastrarProduto(produto);
			mensagens.add("Produto cadastrado");
			modelAnsView.addObject("mensagens", erros);

		}
		modelAnsView.addObject("produtos", produtoService.exibirProdutos());

		return modelAnsView;

	}
	
	@PostMapping("/{id}")
	public ModelAndView cadastrar(@Valid ProdutoModel produto, BindingResult bindingResult) {
		ModelAndView modelAnsView = new ModelAndView("produtos.html");

		List<String> erros = new ArrayList<String>();
		List<String> mensagens = new ArrayList<String>();

		if (bindingResult.hasErrors()) {

			for (ObjectError objectErros : bindingResult.getAllErrors()) {
				erros.add(objectErros.getDefaultMessage());
			}
			modelAnsView.addObject("erros", erros);

		} else {
			produtoService.cadastrarProduto(produto);
			mensagens.add("Produto cadastrado");
			modelAnsView.addObject("mensagens", mensagens);

		}
		modelAnsView.addObject("produtos", produtoService.exibirProdutos());

		return modelAnsView;

	}

	@GetMapping("/{id}")
	public ModelAndView deletaProduto(@PathVariable int id) {
		produtoService.deletarProduto(id);
		ModelAndView modelAndView = new ModelAndView("produtos.html");
		modelAndView.addObject("produtos", produtoService.exibirProdutos());
		return modelAndView;
	}


}

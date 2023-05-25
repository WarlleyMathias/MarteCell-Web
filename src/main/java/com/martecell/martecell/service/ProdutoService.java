package com.martecell.martecell.service;

import com.martecell.martecell.model.Produto;
import com.martecell.martecell.repository.ProdutoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



@org.springframework.stereotype.Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository pr;
	
	public List<Produto> findAll() {
		return pr.findAll();		
	}
	
	public Produto findID(Long id) {
		return pr.findById(id).get();
	}
	
	public List<Produto> findCategoria(String categoria) {
		return pr.findCategoria(categoria);
		
	}
	
	public Produto save(Produto produto) {
		return pr.save(produto);
	}

}

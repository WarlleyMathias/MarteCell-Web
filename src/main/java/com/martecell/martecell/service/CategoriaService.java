package com.martecell.martecell.service;

import com.martecell.martecell.model.Categoria;
import com.martecell.martecell.repository.CategoriaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



@org.springframework.stereotype.Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository cr;
	
	public List<Categoria> findAll() {
		return cr.findAll();		
	}
	
	public Categoria findID(Long id) {
		return cr.findById(id).get();
	}
	
	public Categoria save(Categoria categoria) {
		return cr.save(categoria);
	}

}

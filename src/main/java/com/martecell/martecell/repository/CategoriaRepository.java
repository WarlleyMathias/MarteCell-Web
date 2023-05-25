package com.martecell.martecell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martecell.martecell.model.Categoria;

@org.springframework.stereotype.Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

}

package com.martecell.martecell.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.martecell.martecell.model.Role;
import com.martecell.martecell.model.User;
import com.martecell.martecell.repository.RoleRepository;
import com.martecell.martecell.repository.UserRepository;

@org.springframework.stereotype.Service
public class CadastrarService {
	
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

	public String cadastrar(String nome, String email, String password) {
		
		if(userRepository.findByEmail(email) == null) {
			
			Role role = new Role("ROLE_USER");

	        this.roleRepository.save(role);
	        User user = new User(nome, email, password, Arrays.asList(role));
	        userRepository.save(user);
	        
	        return "Cadastro efutuado com sucesso!";
		}else {
			return "Não foi possivel realizar o cadastro, Email já existente.";
		}

		
	}
}

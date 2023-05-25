package com.martecell.martecell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.martecell.martecell.model.Endereco;
import com.martecell.martecell.model.User;
import com.martecell.martecell.service.EnderecoService;
import com.martecell.martecell.service.UserService;

@Controller
public class PerfilController {
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	EnderecoService enderecoService;
	
	@RequestMapping(value="/perfil", method=RequestMethod.GET)
	public ModelAndView getPerfil() {
		ModelAndView mv = new ModelAndView("perfil");
		User user = userService.usuarioLogado();
		mv.addObject("user", user);
		Endereco endereco = enderecoService.findID(user.getId());
		try {
			if(endereco.equals(null)) {
				endereco = new Endereco();
				endereco.setIdUser(userService.usuarioLogado().getId());
				enderecoService.save(endereco);
				mv.addObject("endereco", endereco);
			}
		}catch(Exception e) {
			endereco = new Endereco();
			endereco.setIdUser(userService.usuarioLogado().getId());
			enderecoService.save(endereco);
			mv.addObject("endereco", endereco);
		}
		
		mv.addObject("endereco", endereco);
		return mv;
	}
	
	@RequestMapping(value="/perfil", method=RequestMethod.POST)
	public String setPerfil() {
		return "redirect:/perfil";	
	}
	
}

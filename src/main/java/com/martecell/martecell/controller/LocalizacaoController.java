package com.martecell.martecell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocalizacaoController {
	
	@RequestMapping(value="/localizacao", method=RequestMethod.GET)
	public ModelAndView getLocalizacao() {
		ModelAndView mv = new ModelAndView("localizacao");
		return mv;
	}

}

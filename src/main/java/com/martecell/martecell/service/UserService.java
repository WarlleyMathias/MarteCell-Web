package com.martecell.martecell.service;

import com.martecell.martecell.model.CustomOAuth2User;
import com.martecell.martecell.model.Role;
import com.martecell.martecell.model.User;
import com.martecell.martecell.model.User.Provider;
import com.martecell.martecell.repository.RoleRepository;
import com.martecell.martecell.repository.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
 
@Service
public class UserService {
 
    @Autowired
    private UserRepository ur;
    
    @Autowired
    private RoleRepository rr;
     
    public void processOAuthPostLogin(String name, String email) {
        User existUser = ur.findByEmail(email);
        
        Role role = rr.findByName("ROLE_USER");
         
        if (existUser == null) {
        	User user = new User(name, email, Provider.GOOGLE, Arrays.asList(role));
            ur.save(user);        
        }
         
    }
    
    public String nomeUsuarioLogado() {
    	try {
    		CustomOAuth2User oauthUser = new CustomOAuth2User((OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	    	return oauthUser.getEmail();
    	}catch(Exception e){
    		return SecurityContextHolder.getContext().getAuthentication().getName();
    	}
    }
    
    public User usuarioLogado() {
    	return ur.findByEmail(nomeUsuarioLogado());
    }
     
}
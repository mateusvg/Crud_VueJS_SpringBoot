package siteempresa.com.br.crubBasico.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siteempresa.com.br.crubBasico.Entity.Users;
import siteempresa.com.br.crubBasico.repositories.UsersRepository;
import siteempresa.com.br.crubBasico.security.JwtToeknUtil;
import siteempresa.com.br.crubBasico.services.JwtUserDetailsService;

@CrossOrigin
@RestController

public class JwtAuthenticateControllers {

	private List<Users> usuarios = new ArrayList<>();
	
	private String token;
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailService;
	
	@Autowired
	private JwtToeknUtil jwtToeknUtil;
	
	@CrossOrigin
	@RequestMapping(value ="/login", method= RequestMethod.POST)
	public String createAuthenticeToken(@RequestBody Users authenticateRequest) {
		// confere se o usuario é o mesmo que esta cadastrado na base
		usuarios = repository.findAll();
		for(Users usuario: usuarios) {
			
			
			if(usuario.getUsername().equals(authenticateRequest.getUsername())&& 
					passwordEncoder.matches(authenticateRequest.getPassword(), usuario.getPassword())) {
				
				final UserDetails userDatails= jwtUserDetailService
						.loadUserByUsername(authenticateRequest.getUsername());
				
				this.token = jwtToeknUtil.genereteToken(userDatails);
			
				
				return this.token;
			}
		}
		
		
		
		return "Error";
	}
}

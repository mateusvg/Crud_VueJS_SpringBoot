package siteempresa.com.br.crubBasico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import siteempresa.com.br.crubBasico.Entity.Users;
import siteempresa.com.br.crubBasico.repositories.UsersRepository;

@Service
public class UsersServices {
	
	@Autowired
	private UsersRepository repository;
	
	@GetMapping
	public List<Users> findall(){
		return repository.findAll();	
	}
	

	
	// CONFIGURAÇÃO DE BIBLIOTECA BCRYPT
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	private String senhaComHash;
	
	
	@GetMapping
	public ResponseEntity<?> findById(@PathVariable long id){
		return repository.findById(id)
				.map(response -> ResponseEntity.ok().body(response))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Users create(@RequestBody Users users) {
		this.senhaComHash = passwordEncoder.encode(users.getPassword());
		users.setPassword(this.senhaComHash);
		return repository.save(users);
	}
	
	@RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
	public Users update(@RequestBody Users users, @PathVariable long id) {
		users.setId(id);
		return repository.save(users);
	}
	
	public ResponseEntity<?> delete (@PathVariable long id){
		repository.deleteById(id);
		return null;
	}
	
}

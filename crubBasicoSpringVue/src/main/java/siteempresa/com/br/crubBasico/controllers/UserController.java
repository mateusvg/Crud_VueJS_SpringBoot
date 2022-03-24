package siteempresa.com.br.crubBasico.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import siteempresa.com.br.crubBasico.Entity.Users;

import siteempresa.com.br.crubBasico.services.UsersServices;

@RestController
@RequestMapping({"/users"})
public class UserController {

	// FAZ A INJEÇÃO DA CLASSE CATEGORYSERVICE DENTRO DE CATEGORYCONTROLLER
	@Autowired
	private UsersServices service;
	
	// CLASSE JA TRAZ EMBUTIDA AS RESPOSTAS HTTP 400..500
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		List<Users> list = service.findall();
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		ResponseEntity<?> list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Users> create(@RequestBody Users users){
		users = service.create(users);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(users.getId()).toUri();
		return ResponseEntity.created(uri).body(users);
	}
	
	@CrossOrigin
	@RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
	public ResponseEntity<Users> update(@RequestBody Users users, @PathVariable Long id){	
		users = service.update(users, id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping(value = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Deletado");
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}

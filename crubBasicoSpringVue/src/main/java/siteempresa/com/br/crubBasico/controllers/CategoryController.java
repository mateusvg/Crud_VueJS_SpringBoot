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

import siteempresa.com.br.crubBasico.Entity.Category;
import siteempresa.com.br.crubBasico.services.CategoryService;

@RestController
@RequestMapping({"/categories"})
public class CategoryController {

	// FAZ A INJEÇÃO DA CLASSE CATEGORYSERVICE DENTRO DE CATEGORYCONTROLLER
	@Autowired
	private CategoryService service;
	
	// RESPONSEENTITY ==> TRAZ EMBUTIDA AS RESPOSTAS HTTP 400..500
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@CrossOrigin
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		Category list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Category> create(@RequestBody Category category){
		category = service.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
		return ResponseEntity.created(uri).body(category);
	}
	@CrossOrigin
	@RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
	public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id){	
		category = service.update(category, id);
		return ResponseEntity.noContent().build();
	}
	@CrossOrigin
	@DeleteMapping(path= {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}

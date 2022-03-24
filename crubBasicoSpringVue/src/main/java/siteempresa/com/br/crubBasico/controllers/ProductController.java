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

import siteempresa.com.br.crubBasico.Entity.Product;
import siteempresa.com.br.crubBasico.services.ProductService;

@RestController
@RequestMapping({"/products"})
public class ProductController {

	// FAZ A INJEÇÃO DA CLASSE CATEGORYSERVICE DENTRO DE CATEGORYCONTROLLER
	@Autowired
	private ProductService service;
	
	// CLASSE JA TRAZ EMBUTIDA AS RESPOSTAS HTTP 400..500
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<?> findById(@PathVariable Long id){
		Product list = service.findById(id);
		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product){
		product = service.save(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(product);
	}
	
	@CrossOrigin
	@RequestMapping(value = {"/{id}"},method = RequestMethod.PUT)
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){	
		product = service.update(product, id);
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

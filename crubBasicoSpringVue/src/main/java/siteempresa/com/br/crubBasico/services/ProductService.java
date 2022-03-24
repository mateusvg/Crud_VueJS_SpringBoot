package siteempresa.com.br.crubBasico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteempresa.com.br.crubBasico.Entity.Product;
import siteempresa.com.br.crubBasico.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id){
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	public Product save(Product product) {
		return repository.save(product);
	}
	
	public Product update(Product product, Long id) {
		product.setId(id);
		return repository.save(product);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}

package siteempresa.com.br.crubBasico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siteempresa.com.br.crubBasico.Entity.Category;
import siteempresa.com.br.crubBasico.exceptions.ResourceNotFoundException;
import siteempresa.com.br.crubBasico.repositories.CategoryRepository;

// NOTAÇÃO DO SPRING QUE DIZ QUE A CLASSE É UMA CLASSE DE SERVIÇO
@Service
public class CategoryService {

	// FAZ A INJEÇÃO DIRETA DA ENTIDADE REPOSITORY
	@Autowired
	private CategoryRepository repository;
	
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	//CLASSE DO JAVA QUE PODE OU nÂO TRAZER O OBJETO VAZIO OU COM O ID
	public Category findById(Long id){
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id) );
	}
	
	// SALVA ALGO NO BANCO DE DADOS
	public Category save(Category category) {
		return repository.save(category);
	}
	
	// ATUALIZAÇÃO DO BANCO DE DADOS
	public Category update (Category category, Long id) {
		category.setId(id);
		return repository.save(category);
	}
	
	// DELETAR ALGO NO BANCO DE DADOS
	public void delete (Long id) {
		repository.deleteById(id);
	}
}

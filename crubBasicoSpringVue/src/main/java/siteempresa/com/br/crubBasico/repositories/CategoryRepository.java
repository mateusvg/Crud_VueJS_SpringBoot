package siteempresa.com.br.crubBasico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import siteempresa.com.br.crubBasico.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

package siteempresa.com.br.crubBasico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import siteempresa.com.br.crubBasico.Entity.Product;

public interface ProductRepository extends JpaRepository< Product, Long>{

}

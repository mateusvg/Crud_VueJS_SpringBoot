package siteempresa.com.br.crubBasico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import siteempresa.com.br.crubBasico.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}

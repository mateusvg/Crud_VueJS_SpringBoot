package siteempresa.com.br.crubBasico.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


// AQUI VC DESCREVE PARA O JPA QUE ESSA CLASSE É UMA ENTIDADE NO BANCO DADOS

@Entity
@Table(name = "categories") // AQUI VOCE DESCREVE QUAL VAI SER O NOME DA TABELA NO BANCO DE DADOS
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// AQUI VC DIZ QUE O ID VAI SER A CHAVE PRIMÁRIA E ESSSE ID VAI SER GERADO COMO UMA IDENTIFICAÇÃO DESSA TABELA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// RENALACIONAMENTO CATEGORIA E PRODUTO recebe um array list dos produtos
	// "category" abaixo será mapeado na classe produto
	@OneToMany(mappedBy ="category")
	private List<Product> produtos = new ArrayList<>();
	
	
	// CONSTRUTOR BASICO
	public Category() {
		
	}

	// CONSTRUTOR COM ATRIBUTOS
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//GETTER E SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// GERAÇÃO DE HASH CODE EQUALS PARA PESQUISA DE ENTIDADE.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}

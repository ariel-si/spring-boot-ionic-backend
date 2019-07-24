package br.com.ariel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ariel.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository2 extends JpaRepository<Produto, Integer>{
	

}

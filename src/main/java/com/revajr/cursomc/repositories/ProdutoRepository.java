package com.revajr.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revajr.cursomc.dominio.Categoria;
import com.revajr.cursomc.dominio.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

// Forma básica usando @Query
//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat "
//			+ "WHERE obj.nome LIKE %:nome% AND cat IN :categorias ")
//	Page<Produto> search(@Param("nome")String nome, @Param("categorias")List<Categoria> categorias, Pageable pageRequest);

	
//	Forma avançada utilizando Query Methods of JPA. See: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods
	@Transactional(readOnly=true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);


}

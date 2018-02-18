package com.revajr.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.revajr.cursomc.dominio.Categoria;
import com.revajr.cursomc.repositories.CategoriaRepository;
import com.revajr.cursomc.services.exceptions.DataIntegrityException;
import com.revajr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: "+id
					+ ", Tipo: "+Categoria.class.getName());
		}
			
		return obj;
	}
		
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try{
			repo.delete(id);
		}catch (DataIntegrityViolationException dive) {
			throw new DataIntegrityException("Não é possível excluir uma CATEGORIA que possui PRODUTOS");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}

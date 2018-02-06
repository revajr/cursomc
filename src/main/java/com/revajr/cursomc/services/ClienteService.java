package com.revajr.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revajr.cursomc.dominio.Cliente;
import com.revajr.cursomc.repositories.ClienteRepository;
import com.revajr.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! id: "+id
					+ ", Tipo: "+Cliente.class.getName());
		}
			
		return obj;
	}
}

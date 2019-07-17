package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Administrador;
import br.senai.sc.repositories.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
	private AdministradorRepository repo;
	
	public Administrador findById(Integer id) {
		Optional<Administrador> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Administrador> findAll(){
		return repo.findAll();
	}
	
	public void insert(Administrador obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Administrador obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

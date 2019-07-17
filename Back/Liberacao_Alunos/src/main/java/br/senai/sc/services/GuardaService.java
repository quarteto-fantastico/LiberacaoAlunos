package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Guarda;
import br.senai.sc.repositories.GuardaRepository;

@Service
public class GuardaService {

	@Autowired
	private GuardaRepository repo;
	
	public Guarda findById(Integer id) {
		Optional<Guarda> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Guarda> findAll(){
		return repo.findAll();
	}
	
	public void insert(Guarda obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Guarda obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

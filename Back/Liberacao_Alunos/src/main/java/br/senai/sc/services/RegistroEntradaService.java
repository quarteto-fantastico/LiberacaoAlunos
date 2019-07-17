package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.RegistroEntrada;
import br.senai.sc.repositories.RegistroEntradaRepository;

@Service
public class RegistroEntradaService {

	@Autowired
	private RegistroEntradaRepository repo;
	
	public RegistroEntrada findById(Integer id) {
		Optional<RegistroEntrada> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<RegistroEntrada> findAll(){
		return repo.findAll();
	}
	
	public void insert(RegistroEntrada obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(RegistroEntrada obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

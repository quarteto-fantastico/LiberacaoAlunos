package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.RegistroSaida;
import br.senai.sc.repositories.RegistroSaidaRepository;

@Service
public class RegistroSaidaService {

	@Autowired
	private RegistroSaidaRepository repo;
	
	public RegistroSaida findById(Integer id) {
		Optional<RegistroSaida> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<RegistroSaida> findAll(){
		return repo.findAll();
	}
	
	public void insert(RegistroSaida obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(RegistroSaida obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Responsavel;
import br.senai.sc.repositories.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository repo;
	
	public Responsavel findById(Integer id) {
		Optional<Responsavel> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Responsavel> findAll(){
		return repo.findAll();
	}
	
	public void insert(Responsavel obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Responsavel obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

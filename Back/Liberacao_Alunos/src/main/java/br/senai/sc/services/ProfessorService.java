package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Professor;
import br.senai.sc.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;
	
	public Professor findById(Integer id) {
		Optional<Professor> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Professor> findAll(){
		return repo.findAll();
	}
	
	public void insert(Professor obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Professor obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

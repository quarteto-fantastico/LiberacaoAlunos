package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Turma;
import br.senai.sc.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repo;
	
	public Turma findById(Integer id) {
		Optional<Turma> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Turma> findAll(){
		return repo.findAll();
	}
	
	public void insert(Turma obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Turma obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

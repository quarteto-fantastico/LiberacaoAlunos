package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Aluno;
import br.senai.sc.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
	
	public void insert(Aluno obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public void update(Aluno obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

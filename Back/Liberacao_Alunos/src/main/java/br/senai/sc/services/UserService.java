package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.User;
import br.senai.sc.repositories.UserRepository;
import br.senai.sc.security.UserSS;

@Service
public class UserService {


	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repo;
	
	public User findById(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
	
//	public void insert(User obj) {
//		obj.setId(null);
//		repo.save(obj);
//	}
	
	public User insert(User obj) {
		obj.setId(null);
		obj.setSenha(passwordEncoder.encode(obj.getSenha()));
		return repo.save(obj);
	}
	
	public void update(User obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
}

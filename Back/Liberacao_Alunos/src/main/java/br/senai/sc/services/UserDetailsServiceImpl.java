package br.senai.sc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.User;
import br.senai.sc.repositories.UserRepository;
import br.senai.sc.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = repo.findByEmail(email);
		 
		 if (user == null) {
			 throw new UsernameNotFoundException(email);
		 }
		 return new UserSS(user);
	}
}

package br.senai.sc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.senai.sc.domain.User;
import br.senai.sc.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService serv;
	
	@CrossOrigin
	//@PreAuthorize("hasAnyRole('ADMINISTRADOR')")//deixa listar todos apenas para administradores
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> ListarTodos(){
		List<User> lista = serv.findAll();
		return ResponseEntity.ok(lista);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> buscarPorId(@PathVariable Integer id){
		User obj = serv.findById(id);
		return ResponseEntity.ok(obj);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody User obj){
		obj = serv.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody User obj, @PathVariable Integer id){
		obj.setId(id);
		serv.update(obj);
		return ResponseEntity.noContent().build();
	}

	
}

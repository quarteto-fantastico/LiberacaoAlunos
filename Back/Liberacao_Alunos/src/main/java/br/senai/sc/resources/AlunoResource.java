package br.senai.sc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.domain.Aluno;
import br.senai.sc.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService serv;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> ListarTodos(){
		List<Aluno> lista = serv.findAll();
		return ResponseEntity.ok(lista);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id){
		Aluno obj = serv.findById(id);
		return ResponseEntity.ok(obj);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aluno obj){
		serv.insert(obj);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Aluno obj, @PathVariable Integer id){
		obj.setId(id);
		serv.update(obj);
		return ResponseEntity.noContent().build();
	}

	
}

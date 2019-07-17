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

import br.senai.sc.domain.Turma;
import br.senai.sc.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {

	@Autowired
	private TurmaService serv;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Turma>> ListarTodos(){
		List<Turma> lista = serv.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Turma> buscarPorId(@PathVariable Integer id){
		Turma obj = serv.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Turma obj){
		serv.insert(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)//, consumes = MediaType.APPLICATION_JSON_VALUE
	public ResponseEntity<Void> update(@RequestBody Turma obj, @PathVariable Integer id){
		obj.setId(id);
		serv.update(obj);
		return ResponseEntity.noContent().build();
	}

	
}

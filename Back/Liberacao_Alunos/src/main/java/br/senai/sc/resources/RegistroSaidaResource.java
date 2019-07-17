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

import br.senai.sc.domain.RegistroSaida;
import br.senai.sc.services.RegistroSaidaService;

@RestController
@RequestMapping(value = "/registrosaidas")
public class RegistroSaidaResource {

	@Autowired
	private RegistroSaidaService serv;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RegistroSaida>> ListarTodos(){
		List<RegistroSaida> lista = serv.findAll();
		return ResponseEntity.ok(lista);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RegistroSaida> buscarPorId(@PathVariable Integer id){
		RegistroSaida obj = serv.findById(id);
		return ResponseEntity.ok(obj);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody RegistroSaida obj){
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
	public ResponseEntity<Void> update(@RequestBody RegistroSaida obj, @PathVariable Integer id){
		obj.setId(id);
		serv.update(obj);
		return ResponseEntity.noContent().build();
	}

	
}

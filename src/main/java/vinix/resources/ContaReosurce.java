package vinix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vinix.entities.Conta;
import vinix.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaReosurce {
	
	@Autowired
	private ContaService serv;
	
	@GetMapping
	public ResponseEntity<List<Conta>> findAll(){
		List<Conta> user = serv.findAll();
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value = "/{numero}")
	public ResponseEntity<Conta> findByNumero(@PathVariable Integer numero){
		Conta obj = serv.findByNumero(numero);
		return ResponseEntity.ok().body(obj);
	}
}

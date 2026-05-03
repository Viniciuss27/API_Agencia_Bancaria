package vinix.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import vinix.entities.User;
import vinix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService serv;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> user = serv.findAll();
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<User> findById(@PathVariable String cpf) {
		User obj = serv.findByCPF(cpf);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = serv.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{cpf}")
				.buildAndExpand(obj.getCpf()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable String cpf) {
		serv.delete(cpf);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{cpf}")
	public ResponseEntity<User> update(@PathVariable String cpf, @RequestBody User obj) {
		obj = serv.update(cpf, obj);
		return ResponseEntity.ok().body(obj);
	}

}

package vinix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vinix.entities.User;
import vinix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService serv;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> u = serv.findAll();
		return ResponseEntity.ok().body(u);
	}

}

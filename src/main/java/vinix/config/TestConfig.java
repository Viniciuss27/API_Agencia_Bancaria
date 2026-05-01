package vinix.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import vinix.entities.Conta;
import vinix.entities.User;
import vinix.repositories.ContaRepository;
import vinix.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private ContaRepository cr;
	
	@Override
	public void run(String... args) throws Exception {
		
		User o1 = new User("maria", "1234", "maria@gmail.com");
		User o2 = new User("marcos", "5678", "marcos@gmail.com");
		User o3 = new User("marta", "9876", "marta@gmail.com");
		User o4 = new User("vania", "1234", "vania@gmail.com");
		User o5 = new User("rian", "1234", "rian@gmail.com");
		ur.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
		
		Conta c1 = new Conta(null, o1, 400000.0);
		Conta c2 = new Conta(null, o2, 454.0);
		Conta c3 = new Conta(null, o3, 564.0);
		Conta c4 = new Conta(null, o4, 7000.0);
		Conta c5 = new Conta(null, o5, 40.0);
		cr.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		
	}

}

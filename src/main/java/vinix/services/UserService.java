package vinix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import vinix.entities.User;
import vinix.repositories.UserRepository;
import vinix.services.exceptions.StringException;

@Service
public class UserService {

	@Autowired
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
	
	public User findByCPF(String cpf) {
		Optional<User> obj = rep.findById(cpf);
		return obj.orElseThrow(() -> new StringException(cpf));
	}

	public User insert(User obj) { // para insereir um novo usuario
		return rep.save(obj);
	}

	public void delete(String cpf) {
		try {
			rep.deleteById(cpf);
		} catch (EmptyResultDataAccessException e) {// caso não exista id
			throw new StringException(cpf);
		} catch (DataIntegrityViolationException e) {
			throw new StringException(e.getMessage());
		}
	}

	public User update(String cpf, User obj) {
		try {
		User entity = rep.getReferenceById(cpf);// monitora objeto do banco de dados
		updateData(entity, obj);
		return rep.save(entity);
		}catch(EntityNotFoundException e) {
			throw new StringException(e.getMessage());

		}

	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setCpf(obj.getCpf());
		entity.setConta(obj.getConta());

	}	
}

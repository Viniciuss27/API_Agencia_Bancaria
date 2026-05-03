package vinix.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vinix.entities.Conta;
import vinix.repositories.ContaRepository;
import vinix.services.exceptions.IntegerException;

@Service
public class ContaService {

	@Autowired
	private ContaRepository rep;
	
	public List<Conta> findAll() {
		return rep.findAll();
	}
	
	public Conta findByNumero(Integer id) {
		Optional<Conta> obj = rep.findById(id);
		return obj.orElseThrow(() -> new IntegerException(id));
	}	
}

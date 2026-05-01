package vinix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vinix.entities.Conta;
import vinix.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository rep;
	
	public List<Conta> findAll() {
		return rep.findAll();
	}
	
}

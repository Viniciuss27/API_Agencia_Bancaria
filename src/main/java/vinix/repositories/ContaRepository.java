package vinix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vinix.entities.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{

}

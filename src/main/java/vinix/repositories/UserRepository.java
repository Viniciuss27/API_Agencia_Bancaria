package vinix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vinix.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}

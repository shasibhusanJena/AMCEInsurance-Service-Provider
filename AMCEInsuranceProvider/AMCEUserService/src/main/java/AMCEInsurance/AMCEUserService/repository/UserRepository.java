package AMCEInsurance.AMCEUserService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import AMCEInsurance.AMCEUserService.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}

package green.project.demo.discordBot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import green.project.demo.discordBot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findById(long id);

	Optional<User> findByName(String name);

	// Optional<User> findByGroupId(String group);
}

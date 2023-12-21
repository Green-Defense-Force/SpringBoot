package green.project.demo.discordBot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import green.project.demo.discordBot.entity.lib;

@Repository
public interface librayRepository extends JpaRepository<lib, Long> {
	Optional<lib> findByName(String name);

	Optional<lib> findByGroupId(String group);
}

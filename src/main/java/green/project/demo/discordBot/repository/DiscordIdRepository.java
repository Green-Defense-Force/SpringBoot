package green.project.demo.discordBot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import green.project.demo.discordBot.entity.DiscordId;

public interface DiscordIdRepository extends JpaRepository<DiscordId, Long> {

	Optional<DiscordId> findByName(String name);
}

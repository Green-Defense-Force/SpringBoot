package green.project.demo.discordBot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "GitlabMember")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long discordId;

	@Column
	private Long Id;

	@Column
	private String name;

	@Column
	private String username;

	@Column
	private String state;

	@Column
	private String avatar_url;

	@Column
	private String web_url;
}

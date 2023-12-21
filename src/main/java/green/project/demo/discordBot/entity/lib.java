package green.project.demo.discordBot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class lib {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	// 라이브러리 이름 artifactId
	@Column
	private String name;

	//    라이브러리 그룹Id
	@Column
	private String groupId;
	//    설명
	@Column
	private String sub;

	//    출처
	@Column
	private String fromCon;

}

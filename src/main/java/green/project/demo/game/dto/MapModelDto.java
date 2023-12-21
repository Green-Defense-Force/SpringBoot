package green.project.demo.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapModelDto {

	private String ticketNum;

	private String coinNum;

	private MonsterPreview mapMonsters;

	private String character;

	private String userName;

	private String userLevel;

	private String field;


}

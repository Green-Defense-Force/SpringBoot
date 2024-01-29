package green.project.demo.discordBot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiectMessageDto {

	String userId;

	String title;

	String author;

	String message;

	String link;
}

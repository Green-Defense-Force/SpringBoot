package green.project.demo.discordBot.dto;

import lombok.Data;

@Data
public class IssuesResponseDto {

	private Integer id;
	private Integer iid;
	private Integer project_id;
	private String title;
}

package green.project.demo.discordBot.dto;

import lombok.Data;

@Data
public class GithubAccessTokenDto {

	private String AccessToken;

	private String ResponseUrl;

	private status status;

	private String perid;

	private String projectId;

	private String groupId;

}


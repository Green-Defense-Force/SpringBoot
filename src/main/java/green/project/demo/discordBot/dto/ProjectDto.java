package green.project.demo.discordBot.dto;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

	private Long id;

	private String name;

	private String description;

	private String web_url;

	public ProjectDto ofIssueDtoJson(JSONObject JSONObject) {
		System.out.println(JSONObject.toString());
		ProjectDto projectDto = new ProjectDto();
		projectDto.setId(JSONObject.getLong("id"));
		//
		projectDto.setName(JSONObject.getString("name"));
		//
		projectDto.setDescription(JSONObject.getString("description"));
		//
		projectDto.setWeb_url(JSONObject.getString("web_url"));
		//
		return projectDto;
	}
}

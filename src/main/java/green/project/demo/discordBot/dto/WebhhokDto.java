package green.project.demo.discordBot.dto;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebhhokDto {

	private String event_type;

	// private String user_name;

	private ProjectDto project;

	private UserDto user;

	private List<UserDto> assigns;

	private objectattributes object_attributes;

	public WebhhokDto JsontWebhookDto(JSONObject object) {

		WebhhokDto webhhokDto = new WebhhokDto();

		webhhokDto.setEvent_type(object.getString("event_type"));
		System.out.println("event_type");

		UserDto userDto = new UserDto();
		webhhokDto.setUser(userDto.UserDtotoWebhhokDtoJson(object.getJSONObject("user")));
		System.out.println("user");

		UserDto assigns = new UserDto();
		if (object.has("assignees") && object.get("assignees") instanceof JSONArray) {
			webhhokDto.setAssigns(assigns.UserDtotoWebhhokDtoJsonList(object.getJSONArray("assignees")));
			System.out.println("assignees");
		} else {
			System.out.println("여기가문젠가?");
			webhhokDto.setAssigns(null);
		}

		//
		ProjectDto projectDto = new ProjectDto();

		webhhokDto.setProject(projectDto.ofIssueDtoJson(object.getJSONObject("project")));
		System.out.println("project");

		objectattributes objectattributes = new objectattributes();
		webhhokDto.setObject_attributes(
			objectattributes.ofobjectattributesJson(object.getJSONObject("object_attributes")));
		System.out.println("object_attributes");

		return webhhokDto;
	}
	// public IssueDto ofIssueDtoJson(JSONObject jsonObject) {
	// 	IssueDto issueDto = new IssueDto();
	//
	// 	issueDto.setTitle(jsonObject.getJSONObject("object_attributes").getString("title"));
	// 	issueDto.setDescription(jsonObject.getJSONObject("object_attributes").getString("description"));
	// 	issueDto.setState(jsonObject.getJSONObject("object_attributes").getString("state"));
	// 	issueDto.setCreated_at(jsonObject.getJSONObject("object_attributes").getString("created_at"));
	// 	issueDto.setUpdated_at(jsonObject.getJSONObject("object_attributes").getString("updated_at"));
	//
	// 	// Check if "closed_at" is present in the JSON
	// 	if (jsonObject.getJSONObject("object_attributes").has("closed_at")) {
	// 		issueDto.setClosed_at(jsonObject.getJSONObject("object_attributes").getString("closed_at"));
	// 	} else {
	// 		issueDto.setClosed_at(null);
	// 	}
	//
	// 	// Assuming "type" is present in "object_attributes"
	// 	issueDto.setType(jsonObject.getJSONObject("object_attributes").getString("type"));
	//
	// 	// Extracting author information
	// 	JSONObject authorObject = jsonObject.getJSONObject("user");
	// 	UserDto authorUserDto = new UserDto();
	// 	UserDto authorUserDtoRe = authorUserDto.UserDtoJson(authorObject);
	//
	// 	issueDto.setAuthor(authorUserDtoRe);
	//
	// 	return issueDto;
	// }
}

package green.project.demo.discordBot.dto;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {

	private String title;

	private String description;

	private String state;

	private String created_at;

	private String updated_at;

	private String closed_at;

	// 해야됨
	private UserDto CloseUserInfo;

	// 해야됨
	private UserDto AssigneesUserInfo;

	private UserDto author;

	private String type;

	// 해야됨
	private UserDto assignee;

	// private String user_notes_count;
	//
	// private
	// private String description;
	//
	// private String description;
	//
	// private String description;
	//
	// private String description;
	//
	// private String description;
	//
	// private String description;
	public IssueDto ofIssueDtoJson(JSONObject JSONObject) {

		IssueDto issueDto = new IssueDto();

		issueDto.setTitle(JSONObject.getString("title"));
		//
		issueDto.setDescription(JSONObject.getString("description"));
		//
		issueDto.setState(JSONObject.getString("state"));
		//
		issueDto.setCreated_at(JSONObject.getString("created_at"));
		//
		issueDto.setUpdated_at(JSONObject.getString("updated_at"));
		//

		if (!((JSONObject.get("closed_at") == null) && (JSONObject.get("closed_at").equals(null)))) {
			issueDto.setClosed_at(JSONObject.get("closed_at").toString());
		} else {
			issueDto.setClosed_at(null);
		}

		//
		issueDto.setType(JSONObject.getString("type"));

		JSONObject author = JSONObject.getJSONObject("author");
		UserDto authoruser = new UserDto();
		UserDto authoruserRe = authoruser.UserDtoJson(author);

		issueDto.setAuthor(authoruserRe);

		return issueDto;

		// author.ofIssueDtoJson(author);
		// String name = author.getString("name");

	}

}
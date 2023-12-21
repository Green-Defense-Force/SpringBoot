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
public class MergeDto {

	private String Type;

	private objectattributes object_attributes;

	private UserDto MakeMergeUser;

	private List<UserDto> assigns;

	public MergeDto JsonWebhookDto(JSONObject object) {
		MergeDto mergeDto = new MergeDto();
		mergeDto.setType(object.getString("event_type"));

		UserDto userDto = new UserDto();
		mergeDto.setMakeMergeUser(userDto.UserDtoMergeJson(object.getJSONObject("user")));

		// UserDto assigns = new UserDto();
		// mergeDto.setMakeMergeUser(assigns.UserDtoMergeJson(object.getJSONObject("assignees")));

		UserDto assignees = new UserDto();
		System.out.println("assigns");
		if (object.has("assignees") && object.get("assignees") instanceof JSONArray) {
			mergeDto.setAssigns(assignees.UserDtotoWebhhokDtoJsonList(object.getJSONArray("assignees")));
		} else {
			System.out.println("여기가문젠가?");
			mergeDto.setAssigns(null);
		}
		System.out.println("assignees");

		objectattributes objectattributes = new objectattributes();
		mergeDto.setObject_attributes(
			objectattributes.ofobjectattributesJson(object.getJSONObject("object_attributes")));
		// System.out.println(object.getJSONObject("last_commit").toString());
		// // System.out.println(object.getJSONObject("target").toString());
		// // System.out.println(object.getJSONObject("source").toString());
		return mergeDto;
	}

	public MergeDto JsonNoteWebhookDto(JSONObject object) {
		MergeDto mergeDto = new MergeDto();
		mergeDto.setType(object.getString("event_type"));

		UserDto userDto = new UserDto();
		mergeDto.setMakeMergeUser(userDto.UserDtoMergeJson(object.getJSONObject("user")));

		// UserDto assigns = new UserDto();
		// mergeDto.setMakeMergeUser(assigns.UserDtoMergeJson(object.getJSONObject("assignees")));

		UserDto assignees = new UserDto();
		System.out.println("assigns");
		if (object.has("assignees") && object.get("assignees") instanceof JSONArray) {
			mergeDto.setAssigns(assignees.UserDtotoWebhhokDtoJsonList(object.getJSONArray("assignees")));
		} else {
			System.out.println("여기가문젠가?");
			mergeDto.setAssigns(null);
		}
		System.out.println("assignees");

		objectattributes objectattributes = new objectattributes();
		mergeDto.setObject_attributes(
			objectattributes.MergeNoteOfObjectAttributesJson(object.getJSONObject("object_attributes")));
		// System.out.println(object.getJSONObject("last_commit").toString());
		// // System.out.println(object.getJSONObject("target").toString());
		// // System.out.println(object.getJSONObject("source").toString());
		return mergeDto;
	}
}

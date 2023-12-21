package green.project.demo.discordBot.dto;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private int id;

	private String name;

	private String username;

	private String state;

	private String avatar_url;

	private String web_url;

	private String email;

	public UserDto UserDtoJson(JSONObject JSONObject) {

		UserDto userDto = new UserDto();

		userDto.setId(JSONObject.getInt("id"));

		userDto.setName(JSONObject.getString("name"));

		userDto.setUsername(JSONObject.getString("username"));
		userDto.setState(JSONObject.getString("state"));
		userDto.setAvatar_url(JSONObject.getString("avatar_url"));
		userDto.setWeb_url(JSONObject.getString("web_url"));

		return userDto;
		// author.ofIssueDtoJson(author);
		// String name = author.getString("name");

	}

	public UserDto UserDtotoWebhhokDtoJson(JSONObject JSONObject) {

		UserDto userDto = new UserDto();

		userDto.setId(JSONObject.getInt("id"));
		userDto.setName(JSONObject.getString("name"));
		userDto.setUsername(JSONObject.getString("username"));
		userDto.setAvatar_url(JSONObject.getString("avatar_url"));
		userDto.setWeb_url(JSONObject.getString("email"));

		return userDto;
		// author.ofIssueDtoJson(author);
		// String name = author.getString("name");

	}

	public UserDto UserDtoMergeJson(JSONObject JSONObject) {

		UserDto userDto = new UserDto();

		userDto.setId(JSONObject.getInt("id"));

		userDto.setName(JSONObject.getString("name"));

		userDto.setUsername(JSONObject.getString("username"));
		userDto.setAvatar_url(JSONObject.getString("avatar_url"));
		userDto.setEmail(JSONObject.getString("email"));

		return userDto;
		// author.ofIssueDtoJson(author);
		// String name = author.getString("name");

	}

	public List<UserDto> UserDtotoWebhhokDtoJsonList(JSONArray jsonArray) {

		List<UserDto> userDtos = new ArrayList<>();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			UserDto userDto = new UserDto();
			userDto.setId(jsonObject.getInt("id"));
			userDto.setName(jsonObject.getString("name"));
			userDto.setUsername(jsonObject.getString("username"));
			userDto.setAvatar_url(jsonObject.getString("avatar_url"));
			userDto.setWeb_url(jsonObject.getString("email"));

			userDtos.add(userDto);
		}
		return userDtos;
	}

}

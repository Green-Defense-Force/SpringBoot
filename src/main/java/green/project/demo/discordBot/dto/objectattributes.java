package green.project.demo.discordBot.dto;

import java.util.List;

import org.json.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class objectattributes {

	// 	Merge Request Attributes:
	// 		- Assignee ID: 55
	// 		- Author ID: 55
	// 		- Created At: 2023-12-14 05:17:46 UTC
	// - Description: 테스트 로직 -> DM 로직으로 수정
	// - URL: http://172.16.104.11/incubator/library/-/merge_requests/27
	// 		- Source Branch: feat-3-GitlabSearchIssue
	// - Target Branch: master
	// - Merge Status: preparing
	// - Last Commit ID: 13c04570f22fa915652cb0a5ac662fb278411e0b
	// - Work In Progress: false
	// 		- State: opened
	// - Action: open
	// 	private String TargetBranch;
	//
	// 	private String MergeStatus;
	//
	// 	private String Action;
	//
	// 	private String

	private Long author_id;

	private String created_at;

	private String description;

	private String url;

	private String source;

	private String target;

	private String last_commit;

	private List<String> assignee_ids;

	private String state;

	private String action;

	private String title;

	private String notevalue;

	public objectattributes ofobjectattributesJson(JSONObject JSONObject) {
		objectattributes objectattributes = new objectattributes();

		objectattributes.setAuthor_id(JSONObject.getLong("author_id"));
		//
		objectattributes.setCreated_at(JSONObject.getString("created_at"));
		//
		objectattributes.setDescription(JSONObject.getString("description"));
		//
		objectattributes.setUrl(JSONObject.getString("url"));
		//
		objectattributes.setTitle(JSONObject.getString("title"));

		return objectattributes;
	}

	public objectattributes MergeOfObjectAttributesJson(JSONObject JSONObject) {
		objectattributes objectattributes = new objectattributes();

		objectattributes.setAuthor_id(JSONObject.getLong("author_id"));
		//
		objectattributes.setCreated_at(JSONObject.getString("created_at"));
		//
		objectattributes.setDescription(JSONObject.getString("description"));
		//
		objectattributes.setUrl(JSONObject.getString("url"));
		//
		objectattributes.setSource(JSONObject.getJSONObject("source").toString());
		objectattributes.setTarget(JSONObject.getJSONObject("target").toString());
		objectattributes.setLast_commit(JSONObject.getJSONObject("last_commit").toString());
		// objectattributes.setState(JSONObject.getString("state"));
		// objectattributes.setAction(JSONObject.getString("action"));

		return objectattributes;
	}

	public objectattributes MergeNoteOfObjectAttributesJson(JSONObject JSONObject) {
		objectattributes objectattributes = new objectattributes();

		objectattributes.setAuthor_id(JSONObject.getLong("author_id"));
		//
		objectattributes.setCreated_at(JSONObject.getString("created_at"));
		//
		objectattributes.setDescription(JSONObject.getString("description"));

		objectattributes.setNotevalue(JSONObject.getString("noteable_type"));
		objectattributes.setTitle(JSONObject.getString("title"));

		//
		objectattributes.setUrl(JSONObject.getString("url"));
		//
		objectattributes.setSource(JSONObject.getJSONObject("source").toString());
		objectattributes.setTarget(JSONObject.getJSONObject("target").toString());
		objectattributes.setLast_commit(JSONObject.getJSONObject("last_commit").toString());
		// objectattributes.setState(JSONObject.getString("state"));
		// objectattributes.setAction(JSONObject.getString("action"));

		return objectattributes;
	}
}

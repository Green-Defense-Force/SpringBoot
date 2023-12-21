package green.project.demo.Challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeDetailModelDto {

	private String challengeId;

	private String challengeTitle;

	private String challengeContent;

	private String challengeGoal;

	private String challengeCorrectExample;

	private String challengeWrongExample;

	private String challengeChecklist;

	private String rewardType;

	private String rewardCount;


}

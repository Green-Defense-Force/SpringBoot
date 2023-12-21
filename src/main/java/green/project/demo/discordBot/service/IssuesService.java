package green.project.demo.discordBot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import green.project.demo.discordBot.entity.DiscordId;
import green.project.demo.discordBot.entity.User;
import green.project.demo.discordBot.dto.GithubAccessTokenDto;
import green.project.demo.discordBot.dto.IssueDto;
import green.project.demo.discordBot.repository.DiscordIdRepository;
import green.project.demo.discordBot.repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssuesService {

	private final UserRepository userRepository;
	private final DiscordIdRepository discordIdRepository;

	private final Logger logger = LoggerFactory.getLogger("IsuesService");

	// 이슈 전체조회 예시
	// public List<IssueDto> IssueSearch(GithubAccessTokenDto githubAccessTokenDto) {
	// 	List<IssueDto> retrunList = new ArrayList<>();
	// 	String ResponseUrl = "";
	// 	ObjectMapper objectMapper = new ObjectMapper();
	//
	// 	// all일때
	// 	if (githubAccessTokenDto.getStatus().equals(status.ALL)) {
	// 		System.out.println(githubAccessTokenDto.getStatus());
	// 		System.out.println(githubAccessTokenDto.getPerid());
	// 		ResponseUrl = "http://172.16.104.11/api/v4/issues?scope=all&&per_page=100";
	// 		githubAccessTokenDto.setResponseUrl(ResponseUrl);
	// 	} else {
	// 		// 추가 로직으로 수정할 부분
	// 		ResponseUrl = "http://172.16.104.11/api/v4/issues?scope=all&&per_page=100";
	// 		githubAccessTokenDto.setResponseUrl(ResponseUrl);
	// 		String ResponseUrl2 = "&&assignee_id=" + githubAccessTokenDto.getPerid();
	// 		ResponseUrl = ResponseUrl + ResponseUrl2;
	// 		System.out.println(ResponseUrl);
	// 	}
	// 	List<IssueDto> issueDtos = SearchIssues(githubAccessTokenDto);
	// 	return issueDtos;
	// }

	// 그룹 이슈 조회 service
	// 그룹 id -> 그룹 맴버
	// @Scheduled(fixedDelay = 10000000)
	public List<IssueDto> Searchinput(GithubAccessTokenDto githubAccessTokenDto) {
		List<IssueDto> retIssueDtos = new ArrayList<>();
		boolean visted = true;
		String ResponseUrl = "";
		// 그룹 조회 , 프로젝트 별조회 ,전체조회
		if (githubAccessTokenDto.getGroupId() != null && !StringUtils.isEmpty(githubAccessTokenDto.getGroupId())) {
			System.out.println("1");
			System.out.println(githubAccessTokenDto.getGroupId());
			// IssueDto issueDto = new IssueDto();
			ResponseUrl = "" + githubAccessTokenDto.getGroupId()
				+ "/issues?assignee_id=None&&scope=all&&per_page=100";
			githubAccessTokenDto.setResponseUrl(ResponseUrl);
			List<IssueDto> issueDtos = SearchIssues(githubAccessTokenDto);
			retIssueDtos.addAll(issueDtos);
			visted = false;
		}
		if (githubAccessTokenDto.getProjectId() != null && !StringUtils.isEmpty(githubAccessTokenDto.getProjectId())) {
			System.out.println("2");
			System.out.println(githubAccessTokenDto.getProjectId());
			ResponseUrl = "" + githubAccessTokenDto.getProjectId()
				+ "/issues?assignee_id=None&&scope=all&&per_page=100";
			githubAccessTokenDto.setResponseUrl(ResponseUrl);
			List<IssueDto> issueDtos = SearchIssues(githubAccessTokenDto);
			retIssueDtos.addAll(issueDtos);
			visted = false;
		}
		// System.out.println(retIssueDtos);
		// System.out.println(retIssueDtos.size() == 0);
		// System.out.println(retIssueDtos.size() == 0 && githubAccessTokenDto.getProjectId() == null
		// 	&& githubAccessTokenDto.getGroupId() == null);
		// System.out.println(githubAccessTokenDto.getProjectId());
		// System.out.println(githubAccessTokenDto.getGroupId());
		System.out.println(visted);
		if (visted) {
			System.out.println("3");
			ResponseUrl = "";
			githubAccessTokenDto.setResponseUrl(ResponseUrl);
			List<IssueDto> issueDtos = SearchIssues(githubAccessTokenDto);
			System.out.println(issueDtos);
			retIssueDtos.addAll(issueDtos);
		}
		System.out.println("4");

		return retIssueDtos;
	}

	//  그룹/프로젝트 아이디를 넣으면 어사인이 안달린 이슈 목록으로 응답주는 api랑요
	public List<IssueDto> SearchIssues(GithubAccessTokenDto githubAccessTokenDto) {

		List<IssueDto> issueDtos = new ArrayList<>();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {

			HttpGet httpGet = new HttpGet(githubAccessTokenDto.getResponseUrl());
			httpGet.setHeader("PRIVATE-TOKEN", githubAccessTokenDto.getAccessToken());

			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

			try {
				Scanner scanner = new Scanner(closeableHttpResponse.getEntity().getContent());
				while (scanner.hasNext()) {
					JSONArray jsonArray = new JSONArray(scanner.nextLine());

					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject object = jsonArray.getJSONObject(i);
						IssueDto issueDto = new IssueDto();
						IssueDto reiIssueDto = issueDto.ofIssueDtoJson(object);

						issueDtos.add(reiIssueDto);
					}
				}
			} finally {
				closeableHttpResponse.close();
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return issueDtos;
	}

	public int countMember(GithubAccessTokenDto githubAccessTokenDto) {
		int count = 0;

		if (githubAccessTokenDto.getProjectId() != null && !StringUtils.isEmpty(githubAccessTokenDto.getProjectId())) {
			count = count + Integer.parseInt(countProjectInt(githubAccessTokenDto.getProjectId()));
		}

		if (githubAccessTokenDto.getGroupId() != null && !StringUtils.isEmpty(githubAccessTokenDto.getGroupId())) {
			count = count + Integer.parseInt(countGroupInt(githubAccessTokenDto.getGroupId()));
		}
		return count;
	}

	// group ID - > 총 사람명수
	public String countGroupInt(String id) {
		System.out.println(id);
		// GET /groups/:id/members
		// GET /projects/:id/members
		String ResponseUrl =
			"" + id + "/members?exclude_external=true&&active=true&&per_page=100";
		String privatetoken = "zJxwxqGxVnphfGD2n7_e";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(ResponseUrl);
		httpGet.setHeader("PRIVATE-TOKEN", privatetoken);

		try {
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
			String totalHeader = closeableHttpResponse.getFirstHeader("X-Total").getValue();
			return totalHeader;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "찾을수가 없습니다.";
	}

	public String countProjectInt(String id) {
		System.out.println(id);
		// GET /groups/:id/members
		// GET /projects/:id/members
		String ResponseUrl =
			"" + id
				+ "/members/all?exclude_external=true&&active=true&&per_page=100";
		String privatetoken = "zJxwxqGxVnphfGD2n7_e";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(ResponseUrl);
		httpGet.setHeader("PRIVATE-TOKEN", privatetoken);

		try {
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
			String totalHeader = closeableHttpResponse.getFirstHeader("X-Total").getValue();
			return totalHeader;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "찾을수가 없습니다.";
	}

	// 전체맴버 저장 DB
	@Scheduled(fixedDelay = 1000000000)
	public void selectMemeber() {
		String ResponseUrl = "";
		String privatetoken = "zJxwxqGxVnphfGD2n7_e";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		ObjectMapper objectMapper = new ObjectMapper();

		HttpGet httpGet = new HttpGet(ResponseUrl);

		httpGet.setHeader("PRIVATE-TOKEN", privatetoken);
		try {

			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
			try {
				// System.out.println(closeableHttpResponse.getEntity().getContent().toString() );
				Scanner scanner = new Scanner(closeableHttpResponse.getEntity().getContent());
				// System.out.println(scanner.nextLine());
				// scanner.
				List<User> users = objectMapper.readValue(scanner.nextLine(), new TypeReference<List<User>>() {
				});

				System.out.println(users.size());

				for (User user : users) {
					userRepository.save(user);
					// System.out.println(user.getName());
				}

				while (scanner.hasNext()) {

					System.out.println(scanner.nextLine());
				}
			} finally {
				closeableHttpResponse.close();
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		// httpGet.setHeader("PRIVATE-TOKEN", githubAccessTokenDto.getAccessToken());
	}

	//discord 아이디 저장 로직
	// @Scheduled(fixedDelay = 1000000000)
	// public void hardcoding() {
	//
	// 	DiscordId discordId = new DiscordId();
	// 	String simbonggyo = "심봉교";
	// 	String simbonggyodiscord = "421706316399116290";
	// 	discordId.setDiscordId(simbonggyodiscord);
	// 	discordId.setName(simbonggyo);
	// 	discordIdRepository.save(discordId);
	// 	System.out.println("심봉교완료");
	//
	// 	DiscordId discordId2 = new DiscordId();
	// 	String kim = "김선우";
	// 	String kimdiscord = "1049173754321834005";
	// 	discordId2.setDiscordId(kimdiscord);
	// 	discordId2.setName(kim);
	// 	discordIdRepository.save(discordId2);
	// 	System.out.println("김선우완료");
	//
	// 	DiscordId discordId3 = new DiscordId();
	// 	String chai = "최용욱";
	// 	String chaidiscord = "471162529653981185";
	// 	discordId3.setDiscordId(chaidiscord);
	// 	discordId3.setName(chai);
	// 	discordIdRepository.save(discordId3);
	// 	System.out.println("최용욱완료");
	//
	// 	DiscordId discordId4 = new DiscordId();
	// 	String chaijong = "최종성";
	// 	String chaijongdiscord = "1182225625788977185";
	// 	discordId4.setDiscordId(chaijongdiscord);
	// 	discordId4.setName(chaijong);
	// 	discordIdRepository.save(discordId4);
	// 	System.out.println("최종성완료");
	//
	// 	DiscordId discordId5 = new DiscordId();
	// 	String jeongwan = "유정완";
	// 	String jeongwandiscord = "1182509261813727254";
	// 	discordId5.setDiscordId(jeongwandiscord);
	// 	discordId5.setName(jeongwan);
	// 	discordIdRepository.save(discordId5);
	// 	System.out.println("유정완완료");
	//
	// 	DiscordId discord6 = new DiscordId();
	// 	String sin0 = "유신영";
	// 	String sin0discord = "1182513148721381427";
	// 	discord6.setDiscordId(sin0discord);
	// 	discord6.setName(sin0);
	// 	discordIdRepository.save(discord6);
	// 	System.out.println("유신영완료");
	// }
}

package green.project.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class MainController {

	@Operation(summary = "문자열 반복", description = "파라미터로 받은 문자열을 2번 반복합니다.")
	@Parameter(name = "str", description = "2번 반복할 문자열")
	@GetMapping("/returnStr")
	public String returnStr(@RequestParam String str) {
		return str + "\n" + str;
	}

	@GetMapping("/example")
	public String example() {
		return "예시 API";
	}

	@Hidden
	@GetMapping("/ignore")
	public String ignore() {
		return "무시되는 API";
	}

}

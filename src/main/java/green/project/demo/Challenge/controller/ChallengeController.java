package green.project.demo.Challenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {


	@GetMapping("/Challenge")
	public ResponseEntity<?> Challenge(String example) {
		System.out.println(example);

	return null;
	}

	@PostMapping("/Challenge")
	public ResponseEntity<?> ChallengePost(@RequestBody String example) {
		System.out.println(example);

		return null;
	}
	@PutMapping("/Challenge")
	public ResponseEntity<?> ChallengePut(String example) {
		System.out.println(example);
		return null;
	}
	@DeleteMapping("/Challengee")
	public ResponseEntity<?> ChallengeDelete(String example) {
		System.out.println(example);

		return null;
	}
}

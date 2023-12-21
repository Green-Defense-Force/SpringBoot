package green.project.demo.game.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {


	@GetMapping("/Game")
	public ResponseEntity<?> Game(String example) {
		System.out.println(example);

	return null;
	}

	@PostMapping("/Game")
	public ResponseEntity<?> GamePost(String example) {
		System.out.println(example);

		return null;
	}
	@PutMapping("/Game")
	public ResponseEntity<?> GamePut(String example) {
		System.out.println(example);

		return null;
	}
	@DeleteMapping("/Game")
	public ResponseEntity<?> GameDelete(String example) {
		System.out.println(example);

		return null;
	}
}

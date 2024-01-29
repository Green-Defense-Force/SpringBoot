package green.project.demo.plogging.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PloggingController {


	@GetMapping("/plogging")
	public ResponseEntity<?> plogging(String example) {
		System.out.println(example);

	return null;
	}

	@PostMapping("/plogging")
	public ResponseEntity<?>  ploggingPost(@RequestBody String bong) {
		System.out.println("post");
		System.out.println(bong);


		return null;
	}
	@PutMapping("/plogging")
	public ResponseEntity<?> ploggingPut(String example) {
		System.out.println(example);

		return null;
	}
	@DeleteMapping("/plogging")
	public ResponseEntity<?> ploggingDelete(String example) {
		System.out.println(example);

		return null;
	}
}

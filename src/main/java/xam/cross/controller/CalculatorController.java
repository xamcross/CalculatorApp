package xam.cross.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/calculator")
@Slf4j
public class CalculatorController {

	@GetMapping
	public ResponseEntity<?> getCalculation(@RequestParam final int first, @RequestParam final int second) {
		log.info("Summing up two numbers: {} + {}", first, second);
		return ok(first + second);
	}
}

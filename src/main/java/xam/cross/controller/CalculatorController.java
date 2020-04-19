package xam.cross.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@GetMapping
	public ResponseEntity<?> getCalculation() {
		return ok("Calculation finished");
	}
}

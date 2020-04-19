package xam.cross;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("xam.cross.*")
public class AppRunner {
	public static void main(String[] args) {
		SpringApplication.run(AppRunner.class, args);
	}
}

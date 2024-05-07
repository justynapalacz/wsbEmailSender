package palaczjustyna.EmailSander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailSanderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSanderApplication.class, args);
	}
}

package Custom_HOUSE.CH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "Custom_HOUSE.CH")
@EnableAutoConfiguration
public class ChApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChApplication.class, args);
	}

}

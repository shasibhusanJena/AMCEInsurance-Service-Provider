package AMCEInsurance.AMCEClaimService.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AmceClaimServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(AmceClaimServiceApplication.class, args);
	}

}

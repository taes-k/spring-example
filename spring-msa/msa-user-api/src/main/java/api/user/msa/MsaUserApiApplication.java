package api.user.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaUserApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaUserApiApplication.class, args);
	}

}

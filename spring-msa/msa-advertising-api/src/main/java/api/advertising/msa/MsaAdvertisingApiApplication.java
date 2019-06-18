package api.advertising.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaAdvertisingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaAdvertisingApiApplication.class, args);
	}

}

package api.news.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaNewsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaNewsApiApplication.class, args);
	}

}

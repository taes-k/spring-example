package server.auth.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class MsaAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaAuthServerApplication.class, args);
	}

}

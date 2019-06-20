package server.auth.msa.init;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import server.auth.msa.security.User;
import server.auth.msa.security.UserDao;

/**
 * H2 초기계정 세팅
 * @author taes
 *
 */
@Component
public class DataInitializer implements ApplicationRunner {

	@Resource (name="UserDao")
	private UserDao UserDao;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		User newUser = new User();	    
	    PasswordEncoder passwordEncoder;
	    passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    newUser.setUsername("taes");
		newUser.setPassword(passwordEncoder.encode("luke"));
		newUser.setUserType(0);
		newUser.setDate(new Date()); 
		UserDao.save(newUser);
	}

}

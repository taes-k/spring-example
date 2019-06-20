package server.auth.msa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityconfig extends WebSecurityConfigurerAdapter  {	
	
	@Autowired
	private UserInformationService userInformationService;
		
	@Override
    public void configure(HttpSecurity http) throws Exception {
		// h2 데이터를 확인하기위해 h2-console url의 권한을 permitAll으로 바꾸어 줍니다. 
		http.authorizeRequests()
				.antMatchers("/h2-console/**").permitAll()
			.and().csrf().disable()
				.headers().disable();
        
    }
	
    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
    	// custom user인증 서비스를 사용하기위한 설정입니다. 
    	builder.authenticationProvider(authenticationProvider());
    }


	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// authenticationManage 빈 등록 
		return super.authenticationManagerBean();
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		// Spring5부터 PasswordEncoder 지정은 필수로 진행해주어야 합니다. 
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	// custom user인증 서비스를 사용하기위한 설정입니다. 
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userInformationService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
}

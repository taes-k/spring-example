package start.mvc.spring.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter  {	
	
	@Override
    public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/loginSuccess").authenticated()
				.antMatchers("/","/login").permitAll()
			.and().formLogin().permitAll()
				.loginPage("/login")
				.usernameParameter("id")
				.passwordParameter("password")
				.loginProcessingUrl("/loginProcess")
				.defaultSuccessUrl("/loginSuccess")
			.and().logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true) 
				.permitAll()
			.and().csrf().disable()
				.headers().disable();
        
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/script/**", "/image/**", "/fonts/**", "lib/**");
    }
	
    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {
    	builder.authenticationProvider(customAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }
}

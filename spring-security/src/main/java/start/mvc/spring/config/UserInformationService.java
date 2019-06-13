package start.mvc.spring.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import start.mvc.spring.dao.UserDao;
import start.mvc.spring.entity.User;
import start.mvc.spring.entity.UserRole;

@Service ("UserInformationService")
public class UserInformationService implements UserDetailsService {

	@Resource (name="UserDao")
	private UserDao UserDao;


	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserInformation user  = new UserInformation();
		try{ 
            User userEntity = UserDao.findByUid(username);
			user.setUsername(userEntity.getUid());
			user.setPassword(userEntity.getPassword());
			user.setAuthorities(makeGrantedAuthority(userEntity.getRoles()));           
        }catch(Exception e){
            throw new UsernameNotFoundException("wrongId"); // Email 로그인, 저장된 ID 없음
        }
		return user;
	}
	
	public List<GrantedAuthority> makeGrantedAuthority(List<UserRole> roles){
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(role.getRole())));
		return list;
	}
}

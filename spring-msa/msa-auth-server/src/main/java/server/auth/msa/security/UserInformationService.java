package server.auth.msa.security;

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

@Service ("UserInformationService")
public class UserInformationService implements UserDetailsService {

	@Resource (name="UserDao")
	private UserDao UserDao;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = UserDao.findByUsername(username);
        
        // 저장된 ID가 없을때 throw 시켜줍니다. 
        if(user == null) {
        	throw new UsernameNotFoundException("wrongId");
        }
		return makeLoginUser(user);
	}
	
	// UserInformation 값 주입해 줍니다.
	public UserInformation makeLoginUser(User user) {

		UserInformation loginUser  = new UserInformation();
		
		List<GrantedAuthority> Authoritylist = new ArrayList<>();
		switch(user.getUserType()) {
		case 0 :
			// admin
			Authoritylist.add(new SimpleGrantedAuthority("ADMIN"));
		case 1 :
			// user
			Authoritylist.add(new SimpleGrantedAuthority("USER"));
			break;
		}

		loginUser.setUsername(user.getUsername());
		loginUser.setPassword(user.getPassword());
		loginUser.setAuthorities(Authoritylist);
		
		
		return loginUser;
	}
}

package server.auth.msa.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("UserDao")
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}

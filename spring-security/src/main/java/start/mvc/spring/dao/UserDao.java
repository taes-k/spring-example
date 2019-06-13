package start.mvc.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.mvc.spring.entity.User;

@Repository ("UserDao")
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUid(String id);
}

package start.mvc.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import start.mvc.spring.entity.UserRole;

@Repository ("UserRoleDao")
public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
}
